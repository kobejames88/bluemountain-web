package com.bluemoutain.controller;


import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.*;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.VipService;
import com.bluemoutain.service.WebConfigService;
import com.bluemoutain.utils.IpKit;
import com.bluemoutain.utils.PayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 用户充值
 */
@Controller
@RequestMapping("/admin/ch")
public class AccountChangeMoney {

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private VipService vipService;

    /**
     * 账户余额充值
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/index")
    public String change(HttpSession session, Model model) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        SystemUser user = userService.findUserById(info.getId());
        model.addAttribute("user", user);
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        return "admin/change_money/index";
    }

    /**
     * 去支付
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/pay")
    public String pay(SystemOrder order, HttpServletRequest request) throws Exception {
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        if (web.getIsApiOpen() == 0) {
            throw new Exception(web.getCloseApiDetial());
        }
        SystemUser user = userService.findUserById(order.getUid());
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
        order.setCreateTime(new Date());
        order.setStatus(1);
        order.setTitle("用户余额充值");
        order.setOrderType(4);
        order.setIpAddr(IpKit.getRealIp(request));
        order.setNotifyUrl(yiPayFunction.getDomain() + "/admin/ch/pay_notify");
        order.setReturnUrl(yiPayFunction.getDomain() + "/admin/ch/return_page");
        order.setIsSett(1);
        order.setIsNotify(0);
        order.setChNum(1);
        order.setChType(0);
        int oid = orderService.createOrder(order);
        SystemOrder order1 = orderService.findOrderById(oid);
        return "forward:" + PayUtils.switchPayMethod2(request, order1, web);
    }

    /**
     * 支付回调页面
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/return_page")
    public String retPage(String out_trade_no, Model model) throws Exception {
        SystemOrder order = orderService.findOrderByOutOrderId(out_trade_no);
        if (order == null) {
            throw new Exception("order id error!");
        }
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        model.addAttribute("model", order);
        return "admin/change_money/return";
    }

    /**
     * vip购买,续费
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/vip_buy")
    public String buy_vip(HttpSession session, Model model) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        SystemUser user = userService.findUserById(info.getId());
        model.addAttribute("user", user);
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        SystemVip vip = vipService.find_vip_by_uid(user.getId());
        model.addAttribute("vip", vip);
        return "admin/change_money/vip_buy_index";
    }

    /**
     * 去支付 - 购买/续费会员
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/pay2")
    public String pay2(SystemOrder order, HttpServletRequest request) throws Exception {
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        if (web.getIsApiOpen() == 0) {
            throw new Exception(web.getCloseApiDetial());
        }
        SystemUser user = userService.findUserById(order.getUid());
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
        if (order.getChNum() < 1) {
            throw new Exception("购买数量错误,请返回重试!");
        }
        Integer num = order.getChNum();
        order.setCreateTime(new Date());
        order.setStatus(1);
        order.setTitle("开通会员 x " + num + " 份");
        order.setOrderType(4);
        order.setIpAddr(IpKit.getRealIp(request));
        order.setNotifyUrl(yiPayFunction.getDomain() + "/admin/ch/pay_notify");
        order.setReturnUrl(yiPayFunction.getDomain() + "/admin/ch/return_page2");
        order.setIsSett(1);
        order.setIsNotify(0);
        order.setChType(1);
        order.setPrice(web.getVipSale().multiply(new BigDecimal(num)).setScale(2, BigDecimal.ROUND_HALF_UP));
        int oid = orderService.createOrder(order);
        SystemOrder order1 = orderService.findOrderById(oid);
        return "forward:" +  PayUtils.switchPayMethod2(request, order1, web);
    }

    /**
     * 支付回调页面
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/return_page2")
    public String retPage2(String out_trade_no, Model model) throws Exception {
        SystemOrder order = orderService.findOrderByOutOrderId(out_trade_no);
        if (order == null) {
            throw new Exception("order id error!");
        }
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        model.addAttribute("model", order);
        return "admin/change_money/vip_buy_return";
    }


    /**
     * 用户体验
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/vip_mode_test")
    public String vip_mode_test(HttpSession session, Model model) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        SystemUser user = userService.findUserById(info.getId());
        SystemWeb web = webConfigService.find_by_id(1);
        SystemVip vip = vipService.find_vip_by_uid(user.getId());
        model.addAttribute("vip", vip);
        model.addAttribute("config", web);
        model.addAttribute("user", user);
        return "admin/change_money/test_index";
    }

    /**
     * 去支付 - 用户秒到体验
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/pay3")
    public String pay3(SystemOrder order, HttpServletRequest request) throws Exception {
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        if (web.getIsApiOpen() == 0) {
            throw new Exception(web.getCloseApiDetial());
        }
        SystemUser user = userService.findUserById(order.getUid());
        SystemVip vip = vipService.find_vip_by_uid(user.getId());
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
        if (vip.getExperienceNum() <= 0) {
            throw new Exception("体验次数已用完,若想继续使用请购买!");
        }
        if (user.getZspaytype() == 3) {
            throw new Exception("结算方式不支持秒到,请返回修改!");
        }
        if (user.getZspaytype() == 4) {
            throw new Exception("结算方式不支持秒到,请返回修改!");
        }
        order.setCreateTime(new Date());
        order.setStatus(1);
        order.setTitle("用户体验订单");
        order.setContext("用户体验订单");
        order.setOrderType(1);
        order.setChNum(1);
        order.setIpAddr(IpKit.getRealIp(request));
        order.setNotifyUrl(yiPayFunction.getDomain() + "/admin/ch/pay_notify");
        order.setReturnUrl(yiPayFunction.getDomain() + "/admin/ch/return_page3");
        order.setIsSett(1);
        order.setIsNotify(0);
        order.setChType(2);
        order.setPrice(vip.getExperiencePrice());
        int oid = orderService.createOrder(order);
        SystemOrder order1 = orderService.findOrderById(oid);
        return "forward:" +  PayUtils.switchPayMethod2(request, order1, web);
    }

    /**
     * 支付回调页面
     */
    @RequiresPermissions("user_info")
    @RequestMapping("/return_page3")
    public String retPage3(String out_trade_no, Model model) throws Exception {
        SystemOrder order = orderService.findOrderByOutOrderId(out_trade_no);
        if (order == null) {
            throw new Exception("order id error!");
        }
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        model.addAttribute("model", order);
        return "admin/change_money/test_return";
    }


}
