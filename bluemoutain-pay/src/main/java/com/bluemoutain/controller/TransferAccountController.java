package com.bluemoutain.controller;


import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.po.TransferAccount;
import com.bluemoutain.service.TransferAccountService;
import com.bluemoutain.service.UserService;
import com.bluemoutain.service.WebConfigService;
import com.bluemoutain.utils.PageBean;
import com.bluemoutain.utils.PayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * 转账控制
 */
@Controller
@RequestMapping("/admin/ta")
public class TransferAccountController {

    @Autowired
    private TransferAccountService transferAccountService;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private YiPayFunction yiPayFunction;

    @Autowired
    private UserService userService;

    @Autowired
    private WebConfigService webConfigService;

    /**
     * 转账控制
     */
    @RequiresPermissions("sys_ta_list")
    @RequestMapping("/info")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "20") Integer rows,
                        @RequestParam(defaultValue = "false") Boolean ajax,
                        Model model, Integer status, String name, String sid, Integer type) {
        PageBean<TransferAccount> bean = transferAccountService.findByPage(page, rows, status, name, sid, type);
        model.addAttribute("bean", bean);
        model.addAttribute("status", status);
        model.addAttribute("name", name);
        model.addAttribute("sid", sid);
        model.addAttribute("type", type);
        if (ajax) {
            return "admin/ta/list#pagenode";
        } else {
            return "admin/ta/list";
        }
    }

    /**
     * 打款
     */
    @RequiresPermissions("sys_ta_list")
    @RequestMapping("/tr")
    @ResponseBody
    public Map transfer(Integer type, String name, String pid, BigDecimal price, String title, String bank_code, HttpServletRequest request, HttpSession session) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        String psd = UUID.randomUUID().toString().replaceAll("-", "").toLowerCase();
        String strReq = PayUtils.getStrReq();
        TransferAccount account = new TransferAccount();
        Date date = new Date();
        if (bank_code == null) {
            bank_code = "0";
        }
        account.setOptUser(1);
        account.setOptTime(date);
        account.setTitle(title);
        account.setPrice(price);
        account.setPsd(psd.substring(0, 15));
        account.setpType(type);
        account.setPutName(name);
        account.setPutId(pid);
        account.setStatus(1);
        account.setStr(strReq);
        account.setCmmsAmt(new BigDecimal(0.00));
        account.setBankCode(new Integer(bank_code));
        account.setIp(request.getRemoteAddr());
        int id = transferAccountService.saveTF(account);
        HashMap<String, String> param = new HashMap<>();
        param.put("final_money", String.valueOf(price));
        param.put("sid", psd);
        param.put("pid", pid);
        param.put("pname", name);
        param.put("ip", request.getRemoteAddr());
        param.put("title", title);
        param.put("str", strReq);
        param.put("bank", bank_code);
        TransferAccount model = transferAccountService.find_by_id(account.getId());
        if (type == 1) {
            Map money = wxPayFunctionPC.changeMoneyToWxAccountMap(param);
            if (money == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            Object error = money.get("error");
            Integer status = new Integer(money.get("status").toString());
            Object tran_no = money.get("tran_no");
            if (status == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            if (status == 2) {
                model.setStatus(2);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款成功");
                map.put("code", 0);
                return map;
            } else {
                model.setStatus(3);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款失败,原因:" + error);
                map.put("code", -1);
                return map;
            }
        } else if (type == 2) {
            Map money = aliPayFunction.changeMoneyToAccountMap(param);
            if (money == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            Object error = money.get("error");
            Integer status = (Integer) money.get("status");
            Object tran_no = money.get("tran_no");
            if (status == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            if (status == 2) {
                model.setStatus(2);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款成功");
                map.put("code", 0);
                return map;
            } else {
                model.setStatus(3);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款失败,原因:" + error);
                map.put("code", -1);
                return map;
            }
        } else {
            Map money = wxPayFunctionPC.payToUserCard(param);
            if (money == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            Object error = money.get("error");
            Integer status = new Integer(money.get("status").toString());
            Object tran_no = money.get("tran_no");
            if (status == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            if (status == 2) {
                model.setStatus(2);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                model.setCmmsAmt(new BigDecimal(String.valueOf(money.get("cmms_amt"))));
                transferAccountService.updateTF(model);
                map.put("msg", "提交成功,请耐心等待系统到账(第二天)!");
                map.put("code", 0);
                return map;
            } else {
                model.setStatus(1);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款失败,原因:" + error);
                map.put("code", -1);
                return map;
            }
        }
    }

    /**
     * 删除
     */
    @RequiresPermissions("sys_ta_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id) {
        transferAccountService.deleteTF(id);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "删除成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 查看打款信息
     */
    @RequiresPermissions("sys_ta_list")
    @RequestMapping("/view")
    public String view(Integer id, Model model) {
        TransferAccount model1 = transferAccountService.find_by_id(id);
        model.addAttribute("model", model1);
        return "admin/ta/view";
    }

    /**
     * 重新打款
     */
    @RequiresPermissions("sys_ta_list")
    @RequestMapping("/re/tr")
    @ResponseBody
    public Map reTr(Integer id, HttpSession session) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        TransferAccount model = transferAccountService.find_by_id(id);
        HashMap<String, String> param = new HashMap<>();
        param.put("final_money", String.valueOf(model.getPrice()));
        param.put("sid", model.getPsd());
        param.put("pid", model.getPutId());
        param.put("pname", model.getPutName());
        param.put("ip", model.getIp());
        param.put("title", model.getTitle());
        param.put("str", model.getStr());
        param.put("bank", model.getBankCode().toString());
        if (model.getpType() == 1) {
            Map money = wxPayFunctionPC.changeMoneyToWxAccountMap(param);
            if (money == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            Object error = money.get("error");
            Integer status = new Integer(money.get("status").toString());
            Object tran_no = money.get("tran_no");
            if (status == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            if (status == 2) {
                model.setStatus(2);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款成功");
                map.put("code", 0);
                return map;
            } else {
                model.setStatus(3);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款失败,原因:" + error);
                map.put("code", -1);
                return map;
            }
        } else if (model.getpType() == 2) {
            Map money = aliPayFunction.changeMoneyToAccountMap(param);
            if (money == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            Object error = money.get("error");
            Integer status = (Integer) money.get("status");
            Object tran_no = money.get("tran_no");
            if (status == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            if (status == 2) {
                model.setStatus(2);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款成功");
                map.put("code", 0);
                return map;
            } else {
                model.setStatus(3);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款失败,原因:" + error);
                map.put("code", -1);
                return map;
            }
        } else {
            Map money = wxPayFunctionPC.payToUserCard(param);
            if (money == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            Object error = money.get("error");
            Integer status = new Integer(money.get("status").toString());
            Object tran_no = money.get("tran_no");
            if (status == null) {
                map.put("msg", "打款失败!");
                map.put("code", -1);
                return map;
            }
            if (status == 2) {
                model.setStatus(2);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                model.setCmmsAmt(new BigDecimal(String.valueOf(money.get("cmms_amt"))));
                transferAccountService.updateTF(model);
                map.put("msg", "提交成功,请耐心等待系统到账(第二天)!");
                map.put("code", 0);
                return map;
            } else {
                model.setStatus(1);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                transferAccountService.updateTF(model);
                map.put("msg", "打款失败,原因:" + error);
                map.put("code", -1);
                return map;
            }
        }
    }

    /**
     * 微信 - 扫码绑定
     */
    @RequiresPermissions("sys_ta_list")
    @RequestMapping("/scancode/wx")
    public String toWXScancode(Model model) {
        String state = UUID.randomUUID().toString().replaceAll("-", "");
        ValueOperations ops = redisTemplate.opsForValue();
        ops.set("state:" + state, 1);
        redisTemplate.expire("state:" + state, 120, TimeUnit.SECONDS);
        model.addAttribute("url", yiPayFunction.getDomain() + "/wxScanCode2?auth=" + state + "&times=" + System.currentTimeMillis());
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        model.addAttribute("state_bind", state);
        return "qrCode2";
    }

    /**
     * 检测绑定状态
     */
    @RequiresPermissions("sys_ta_list")
    @RequestMapping("/bind_status")
    @ResponseBody
    public Map bind_status(String state) {
        HashMap<Object, Object> map = new HashMap<>();
        ValueOperations ops = redisTemplate.opsForValue();
        Integer bind = (Integer) ops.get("state_bind:" + state);
        String openid = null;
        if (bind == null) {
            map.put("code", -1);
            map.put("msg", "绑定失败!");
            return map;
        }
        if (bind == 125) {
            openid = (String) ops.get("state_bind_openid:" + state);
            map.put("code", 1);
            map.put("msg", "绑定成功!");
        } else {
            map.put("code", -1);
            map.put("msg", "绑定失败!");
            return map;
        }
        map.put("code", 1);
        map.put("openid", openid);
        map.put("msg", "绑定成功!");
        map.put("backurl", "/bind_ok2?state=" + state + "&times=" + System.currentTimeMillis());
        return map;
    }


}
