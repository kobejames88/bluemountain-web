package com.bluemoutain.controller;


import com.bluemoutain.controller.pay.process.UserBalnesChange;
import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.QQPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.po.ext.SystemOrderExt;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.WebConfigService;
import com.bluemoutain.utils.HttpClientUtils;
import com.bluemoutain.utils.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/admin/order")
public class OrderController {

    @Autowired
    private OrderService service;

    @Autowired
    private UserService userService;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private QQPayFunction qqPayFunction;

    @Autowired
    private UserBalnesChange userBalnesChange;

    @Autowired
    private WebConfigService webConfigService;

    /**
     * 订单列表
     */
    @RequiresPermissions("order_list")
    @RequestMapping("/list")
    public String list(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "20") Integer rows,
                       @RequestParam(defaultValue = "false") Boolean ajax,
                       Model model, Integer status, Integer oid, HttpSession session, Integer payType, Integer order_type, String outOrderId) {
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        PageBean<SystemOrderExt> bean;
        if (info.getRole() == 1) {
            bean = service.findByPage2(page, rows, null, status, payType, outOrderId, order_type, oid);
        } else {
            bean = service.findByPage2(page, rows, info.getId(), status, payType, outOrderId, order_type, oid);
        }
        model.addAttribute("order_type", order_type);
        model.addAttribute("bean", bean);
        model.addAttribute("oid", oid);
        model.addAttribute("status", status);
        model.addAttribute("payType", payType);
        model.addAttribute("outOrderId", outOrderId);
        if (ajax) {
            return "admin/order/list#pagenode";
        } else {
            return "admin/order/list";
        }
    }

    /**
     * 订单列表
     */
    @RequiresPermissions("order_list")
    @RequestMapping("/list2")
    public String list2(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "20") Integer rows,
                        @RequestParam(defaultValue = "false") Boolean ajax,
                        Model model, Integer status, Integer oid, Integer payType, Integer order_type, String outOrderId, Integer uid) {
        PageBean<SystemOrderExt> bean = service.findByPage2(page, rows, uid, status, payType, outOrderId, order_type, oid);
        model.addAttribute("order_type", order_type);
        model.addAttribute("bean", bean);
        model.addAttribute("status", status);
        model.addAttribute("payType", payType);
        model.addAttribute("uid", uid);
        model.addAttribute("oid", oid);
        model.addAttribute("outOrderId", outOrderId);
        if (ajax) {
            return "admin/order/list2#pagenode";
        } else {
            return "admin/order/list2";
        }
    }

    /**
     * 查看订单
     */
    @RequiresPermissions("order_list")
    @RequestMapping("/view")
    public String view(Integer id, Model model) {
        SystemOrder order = service.findOrderById(id);
        model.addAttribute("model", order);
        SystemUser systemUser = userService.findUserById(order.getUid());
        model.addAttribute("user2", systemUser);
        return "admin/order/view";
    }

    /**
     * 删除订单
     */
    @RequiresPermissions("sys_user_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id, HttpSession session) {
        HashMap<Object, Object> map = new HashMap<>();
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        if (info.getRole() == 1) {
            service.deleteOrder(id);
            map.put("msg", "删除成功!");
            map.put("code", 0);
        } else {
            map.put("msg", "权限不足!");
            map.put("code", -1);
        }
        return map;
    }

    /**
     * api订单 - 补单
     */
    @RequiresPermissions("order_list")
    @RequestMapping("/re_notify")
    @ResponseBody
    public Map renotify(Integer id) {
        HashMap<Object, Object> map = new HashMap<>();
        String ret = "";
        SystemOrder order = service.findOrderById(id);
        if (order.getOrderType() == 3) {
            String url = order.getNotifyUrl();
            if (url != null) {
                try {
                    String sign = url + "?" + yiPayFunction.buildRequestParaSign(order);
                    System.out.println(sign);
                    map.put("url", sign);
                    ret = HttpClientUtils.get(sign);
                } catch (Exception e) {
                    ret = e.getMessage();
                    map.put("msg", "已重新通知系统,返回:" + ret);
                    return map;
                }
            }
        }
        map.put("msg", "已重新通知系统,返回:" + ret);
        return map;
    }

    /**
     * api订单 - 补单
     */
    @RequiresPermissions("order_list")
    @RequestMapping("/re_notify2")
    @ResponseBody
    public Map renotify2(Integer id) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        SystemOrder order = service.findOrderById(id);
        if (order.getOrderType() == 3) {
            String url = order.getNotifyUrl();
            if (url != null) {
                String sign = url + "?" + yiPayFunction.buildRequestParaSign(order);
                map.put("url", sign);
            }
        }
        map.put("msg", "获取成功 !");
        return map;
    }

    /**
     * 退款
     */
    @RequiresPermissions("order_list")
    @RequestMapping("/refund_order")
    @ResponseBody
    public Map refund_order(Integer id, HttpSession session) throws Exception{
        SystemUser info = (SystemUser) session.getAttribute("userInfo");
        HashMap<Object, Object> map = new HashMap<>();
        if (info.getIsLocked() == 1) {
            map.put("msg", "账户已被锁定,无法操作!");
            map.put("code", -1);
            return map;
        }
        SystemWeb web = webConfigService.find_by_id(1);
        if (web.getIsApiOpen() == 0) {
            map.put("msg", web.getCloseApiDetial());
            map.put("code", -1);
            return map;
        }
        SystemOrder order = service.findOrderById(id);
        if (order == null) {
            map.put("msg", "订单不存在!");
            map.put("code", -1);
            return map;
        } else {
            if (info.getRole() != 1) {
                if (!order.getUid().equals(info.getId())) {
                    map.put("msg", "订单不存在!");
                    map.put("code", -1);
                    return map;
                }
            }
            if (order.getOrderType() == 4) {
                map.put("msg", "订单不支持退款!");
                map.put("code", -1);
                return map;
            }
            if (order.getOrderType() == 2) {
                map.put("msg", "订单不支持退款!");
                map.put("code", -1);
                return map;
            }
            BigDecimal price = order.getPrice();
            BigDecimal balnes = userBalnesChange.getUserbalnes(order.getUid());
            if (info.getRole() != 1) {
                if (balnes.compareTo(price.add(order.getChangeSett())) < 0) {
                    map.put("code", -1);
                    map.put("msg", "账户余额不足,请先充值!");
                    return map;
                }
            }
            Map ret = new HashMap();
            if (order.getPayType() == 2) {//支付宝退款
                ret = aliPayFunction.refund(order);
            } else if (order.getPayType() == 1) {//微信退款
                ret = wxPayFunctionPC.refund(order);
            } else if (order.getPayType() == 3) {//QQ退款
                ret = qqPayFunction.refund(order);
            }
            String msg = (String) ret.get("msg");
            Integer code = (Integer) ret.get("code");
            if (code == 0) {
                userBalnesChange.subUserBalnes(order.getUid(), price.add(order.getChangeSett()));
                map.put("msg", "提交成功,系统返回:" + msg);
                map.put("code", code);
            } else {
                map.put("msg", "提交失败,系统返回:" + msg);
                map.put("code", code);
            }
        }
        return map;
    }


}
