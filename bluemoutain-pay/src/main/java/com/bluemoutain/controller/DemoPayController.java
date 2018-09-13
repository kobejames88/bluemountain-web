package com.bluemoutain.controller;


import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.*;
import com.bluemoutain.po.ext.SystemOrderExt;
import com.bluemoutain.service.*;
import com.bluemoutain.utils.IpKit;
import com.bluemoutain.utils.PageBean;
import com.bluemoutain.utils.PayUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 个人快捷收款页
 */
@Controller
public class DemoPayController {

    private static Logger logger = LoggerFactory.getLogger(DemoPayController.class);

    @Autowired
    private SystemDomainService domainService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserConfigService configService;

    @Autowired
    private UserService userService;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private VipService vipService;

    @Autowired
    private WebConfigService webConfigService;

    /**
     * 快捷支付首页
     */
    @RequestMapping("/quickpass")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "10") Integer rows,
                        @RequestParam(defaultValue = "false") Boolean ajax,
                        Model model,
                        @RequestParam(defaultValue = "1") Integer id) throws Exception {
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        if (web.getPayUrlCheck() == 0) {
            throw new Exception("平台已关闭支付测试和快捷收款功能,详情联系网站管理员!");
        }
        SystemUser user = userService.findUserById(id);
        if (user == null) {
            id = 1;
        }
        SystemConfigWithBLOBs config = configService.findConfigByUid(id);
        model.addAttribute("config", config);
        PageBean<SystemOrderExt> bean = orderService.findByPage2(page, rows, id, null, null, null, 1, null);
        model.addAttribute("model", bean);
        if (ajax) {
            return "quickpass/index#pagenode";
        } else {
            return "quickpass/index";
        }
    }

    /**
     * 去支付
     */
    @RequestMapping("/quickpass/pay")
    public String pay(SystemOrder order, HttpServletRequest request, Model model) throws Exception {
        SystemUser user = userService.findUserById(order.getUid());
        if (user == null) {
            throw new Exception("用户不存在!");
        }
        SystemVip vip = vipService.find_vip_by_uid(user.getId());
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        if (order.getPayType() == 1) {
            if (web.getTestWxpay() == -1) {
                throw new Exception("当前支付接口(微信)已禁止测试,详情联系网站管理员!");
            }
        }
        if (order.getPayType() == 2) {
            if (web.getTestAlipay() == -1) {
                throw new Exception("当前支付接口(支付宝)已禁止测试,详情联系网站管理员!");
            }
        }
        if (order.getPayType() == 3) {
            if (web.getTestQqpay() == -1) {
                throw new Exception("当前支付接口(QQ)已禁止测试,详情联系网站管理员!");
            }
        }
        if (web.getIsApiOpen() == 0) {
            throw new Exception(web.getCloseApiDetial());
        }
        if (web.getPayUrlCheck() == 0) {
            throw new Exception("平台已关闭支付测试和快捷收款功能,详情联系网站管理员!");
        }
        if (vip == null) {
            throw new Exception("新注册用户信息正在初始化,请等一分钟后再试!");
        }
        if (1 == user.getIsLocked()) {
            throw new Exception("账户已被禁用,您无法进行交易!");
        }
        if (order.getOutOrderId() == null) {
            throw new Exception("订单号错误,请返回重试!");
        }
        if (order.getOutOrderId().length() < 10) {
            throw new Exception("订单号错误,请返回重试!");
        }
        if (order.getPayType() == null) {
            throw new Exception("支付方式错误,请返回重试!");
        }
        if (order.getPrice() == null) {
            throw new Exception("金额错误,请返回重试!");
        }
        if (order.getPrice().compareTo(new BigDecimal(0)) <= 0) {
            throw new Exception("金额错误,请返回重试!");
        }
        if (order.getUid() == null) {
            throw new Exception("获取用户id失败,请返回重试!");
        }
        SystemOrder order2 = orderService.findOrderByOutOrderId(order.getOutOrderId());
        if (order2 != null) {
            throw new Exception("订单号已存在,请返回重试!");
        }
        if (web.getOrderFilter() ==1){
            String disableShopPay = web.getDisableShopPay();
            String[] split = disableShopPay.split(",");
            for (String s : split) {
                String title = order.getTitle();
                if (title.contains(s)) {
                    throw new Exception("商品:" + order.getTitle() + " 禁止出售,请返回修改!");
                }
            }
        }
        order.setCreateTime(new Date());
        order.setStatus(1);
        Integer userQq = web.getUseUserQq();
        if (userQq == 0) {
            order.setTitle(web.getPayTitle());
        } else {
            SystemConfigWithBLOBs uid = configService.findConfigByUid(user.getId());
            order.setTitle(uid.getPanel());
        }
        order.setOrderType(1);
        order.setSiteName(web.getSiteName());
        order.setIpAddr(IpKit.getRealIp(request));
        order.setNotifyUrl(yiPayFunction.getDomain() + "/quickpass/pay_notify");
        order.setReturnUrl(yiPayFunction.getDomain() + "/quickpass/return_page");
        order.setIsSett(1);
        order.setIsNotify(0);
        if (vip.getStatus() == 1) {
            order.setChType(2);
        } else {
            order.setChType(0);
        }
        order.setChNum(1);
        int oid = orderService.createOrder(order);
        SystemOrder order1 = orderService.findOrderById(oid);
        String url = PayUtils.switchPayMethod_test(request, order1, web);
        String s = user.getUrl();
        SystemDomain domain = domainService.findByDomain(s);
        if (web.getShowPayReadme() == 1) {
            if (domain == null) {
                model.addAttribute("url", url);
                model.addAttribute("config", web);
                return "pay/readme";
            } else if (domain.getPayShowInfo() == 1) {
                model.addAttribute("url", url);
                model.addAttribute("config", web);
                return "pay/readme";
            } else {
                return "forward:" + url;
            }
        } else {
            return "forward:" + url;
        }
    }

    /**
     * 支付回调页面
     */
    @RequestMapping("/quickpass/return_page")
    public String retPage(String out_trade_no, Model model) throws Exception {
        SystemOrder order = orderService.findOrderByOutOrderId(out_trade_no);
        if (order == null) {
            throw new Exception("order id error!");
        }
        SystemConfigWithBLOBs config = configService.findConfigByUid(order.getUid());
        model.addAttribute("config", config);
        model.addAttribute("model", order);
        return "quickpass/return";
    }

    /**
     * 获取订单id
     */
    @RequestMapping("/quickpass/orderid")
    @ResponseBody
    public Map getOrderId() {
        HashMap<Object, Object> map = new HashMap<>();
        map.put("oid", PayUtils.genOrderId());
        return map;
    }

}
