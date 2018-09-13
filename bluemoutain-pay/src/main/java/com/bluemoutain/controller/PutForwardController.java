package com.bluemoutain.controller;


import com.bluemoutain.plugins.pay.AliPayFunction;
import com.bluemoutain.plugins.pay.WxPayFunction;
import com.bluemoutain.po.PutForward;
import com.bluemoutain.po.PutForwardConfig;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.po.SystemWebWithBLOBs;
import com.bluemoutain.service.PutForwardService;
import com.bluemoutain.service.WebConfigService;
import com.bluemoutain.utils.PageBean;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 自动结算控制
 */
@Controller
@RequestMapping("/admin/pf")
public class PutForwardController {

    @Autowired
    private PutForwardService putForwardService;

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private AliPayFunction aliPayFunction;

    @Autowired
    private WxPayFunction wxPayFunctionPC;

    /**
     * 自动提现设置
     */
    @RequiresPermissions("sys_pf_list")
    @RequestMapping("/info")
    public String index(@RequestParam(defaultValue = "1") Integer page,
                        @RequestParam(defaultValue = "20") Integer rows,
                        @RequestParam(defaultValue = "false") Boolean ajax,
                        Model model,
                        Integer status, String name, String sid, Integer type) {
        PageBean<PutForward> bean = putForwardService.findByPage(page, rows, status, name, sid, type);
        model.addAttribute("bean", bean);
        PutForwardConfig config = putForwardService.findConfig(1);
        model.addAttribute("config", config);
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("auto_sett", web.getAutoSettPay());
        model.addAttribute("status", status);
        model.addAttribute("name", name);
        model.addAttribute("sid", sid);
        model.addAttribute("type", type);
        if (ajax) {
            return "admin/pf/info#pagenode";
        } else {
            return "admin/pf/info";
        }
    }

    /**
     * 更新设置
     */
    @RequiresPermissions("sys_pf_list")
    @RequestMapping("/update")
    @ResponseBody
    public Map save(PutForwardConfig forward, Integer auto_sett) {
        putForwardService.updateConfig(forward);
        SystemWebWithBLOBs web = webConfigService.find_by_id(1);
        web.setAutoSettPay(auto_sett);
        webConfigService.update_web_config(web);
        HashMap<Object, Object> map = new HashMap<>();
        map.put("msg", "保存成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 删除转账记录
     */
    @RequiresPermissions("sys_pf_list")
    @RequestMapping("/delete")
    @ResponseBody
    public Map delete(Integer id) {
        HashMap<Object, Object> map = new HashMap<>();
        putForwardService.deletePF(id);
        map.put("msg", "保存成功!");
        map.put("code", 0);
        return map;
    }

    /**
     * 查看打款信息
     */
    @RequiresPermissions("sys_pf_list")
    @RequestMapping("/view")
    public String view(Integer id, Model model) {
        PutForward model1 = putForwardService.find_by_id(id);
        model.addAttribute("model", model1);
        return "admin/pf/view";
    }

    /**
     * 重新打款
     */
    @RequiresPermissions("sys_pf_list")
    @RequestMapping("/re/tr")
    @ResponseBody
    public Map reTr(Integer id, HttpSession session) throws Exception {
        HashMap<Object, Object> map = new HashMap<>();
        PutForward model = putForwardService.find_by_id(id);
        HashMap<String, String> param = new HashMap<>();
        param.put("final_money", String.valueOf(model.getPrice()));
        param.put("sid", model.getPsd());
        param.put("pid", model.getPutId());
        param.put("pname", model.getPutName());
        param.put("ip", model.getIp());
        param.put("title", model.getTitle());
        param.put("str", model.getStr());
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
            if (status == 2) {
                model.setStatus(2);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                putForwardService.updatePF(model);
                map.put("msg", "打款成功");
                map.put("code", 0);
                return map;
            } else {
                model.setStatus(3);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                putForwardService.updatePF(model);
                map.put("msg", "打款失败,原因:" + error);
                map.put("code", -1);
                return map;
            }
        } else {
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
                putForwardService.updatePF(model);
                map.put("msg", "打款成功");
                map.put("code", 0);
                return map;
            } else {
                model.setStatus(3);
                model.setTrano(String.valueOf(tran_no));
                model.setErrorInfo(String.valueOf(error));
                putForwardService.updatePF(model);
                map.put("msg", "打款失败,原因:" + error);
                map.put("code", -1);
                return map;
            }
        }
    }

}
