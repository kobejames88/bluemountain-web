package com.bluemoutain.controller;


import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.ext.CountRet;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.service.SystemCountService;
import com.bluemoutain.service.UserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 数据统计模块
 */
@Controller
@RequestMapping("/admin/count")
public class SystemCountController {

    @Autowired
    private SystemCountService countService;

    @Autowired
    private SettLementService settLementService;

    @Autowired
    private OrderService orderService;

    @Autowired
    private UserService userService;


    private SimpleDateFormat time = new SimpleDateFormat("yyyy-MM-dd");

    /**
     * 今日统计
     */
    @RequiresPermissions("sys_count_user_today")
    @RequestMapping("/today")
    public String inCount(HttpSession session, Model model) {
        String today = time.format(new Date());
        SystemUser user = (SystemUser) session.getAttribute("userInfo");
        Integer uid = user.getId();
        BigDecimal todayInMoney = countService.todayInMoney(uid, today);
        BigDecimal todaySettMoney = countService.todaySettMoney(uid, today);
        BigDecimal todayChangeMoneySett = countService.todayChangeMoneySett(uid, today);
        BigDecimal todayWaitSettMoney = countService.todayWaitSettMoney(uid, today);
        model.addAttribute("login_user", userService.findUserById(user.getId()));
        model.addAttribute("todayInMoney", todayInMoney);
        model.addAttribute("todaySettMoney", todaySettMoney);
        model.addAttribute("todayChangeMoneySett", todayChangeMoneySett);
        model.addAttribute("todayWaitSettMoney", todayWaitSettMoney);
        Integer order1 = countService.todayCreateOrder(uid, null, today, null);
        Integer order2 = countService.todayCreateOrder(uid, null, today, 3);
        Integer order3 = countService.todayCreateOrder(uid, null, today, 1);
        Integer order4 = countService.todayCreateOrder(uid, 2, today, null);
        Integer order5 = countService.todayCreateOrder(uid, 1, today, null);
        Integer order9 = countService.todayCreateOrder(uid, 3, today, null);
        BigDecimal order6 = countService.todayOrderSettMoneyCount(uid, 2, today);
        model.addAttribute("order1", order1);
        model.addAttribute("order2", order2);
        model.addAttribute("order3", order3);
        model.addAttribute("order4", order4);
        model.addAttribute("order5", order5);
        model.addAttribute("order6", order6);
        model.addAttribute("order9", order9);
        BigDecimal moneyCount1 = countService.todayOrderMoneyCount(uid, 2, today);
        BigDecimal moneyCount2 = countService.todayOrderMoneyCount(uid, 1, today);
        model.addAttribute("moneyCount1", moneyCount1);
        model.addAttribute("moneyCount2", moneyCount2);
        BigDecimal moneyCount3 = countService.todayOrderMoneyCount(uid, 3, today);
        model.addAttribute("moneyCount3", moneyCount3);
        return "admin/count/today";
    }


    /**
     * 全部数据
     */
    @RequiresPermissions("sys_count_user_history")
    @RequestMapping("/history_all")
    public String outCount(HttpSession session, Model model) {
        SystemUser user = (SystemUser) session.getAttribute("userInfo");
        Integer uid = user.getId();
        BigDecimal todayInMoney = countService.todayInMoney(uid, null);
        BigDecimal todaySettMoney = countService.todaySettMoney(uid, null);
        BigDecimal todayChangeMoneySett = countService.todayChangeMoneySett(uid, null);
        BigDecimal todayWaitSettMoney = countService.todayWaitSettMoney(uid, null);
        model.addAttribute("login_user", userService.findUserById(user.getId()));
        model.addAttribute("todayInMoney", todayInMoney);
        model.addAttribute("todaySettMoney", todaySettMoney);
        model.addAttribute("todayChangeMoneySett", todayChangeMoneySett);
        model.addAttribute("todayWaitSettMoney", todayWaitSettMoney);
        Integer order1 = countService.todayCreateOrder(uid, null, null, null);
        Integer order2 = countService.todayCreateOrder(uid, null, null, 3);
        Integer order3 = countService.todayCreateOrder(uid, null, null, 1);
        Integer order4 = countService.todayCreateOrder(uid, 2, null, null);
        Integer order5 = countService.todayCreateOrder(uid, 1, null, null);
        Integer order9 = countService.todayCreateOrder(uid, 3, null, null);
        BigDecimal order6 = countService.todayOrderSettMoneyCount(uid, 2, null);
        model.addAttribute("order1", order1);
        model.addAttribute("order2", order2);
        model.addAttribute("order3", order3);
        model.addAttribute("order4", order4);
        model.addAttribute("order5", order5);
        model.addAttribute("order6", order6);
        model.addAttribute("order9", order9);
        BigDecimal moneyCount1 = countService.todayOrderMoneyCount(uid, 2, null);
        BigDecimal moneyCount2 = countService.todayOrderMoneyCount(uid, 1, null);
        BigDecimal moneyCount3 = countService.todayOrderMoneyCount(uid, 3, null);
        model.addAttribute("moneyCount3", moneyCount3);
        model.addAttribute("moneyCount1", moneyCount1);
        model.addAttribute("moneyCount2", moneyCount2);
        Integer settCountAll = settLementService.settCountAll(uid, null);
        Integer settPayOkCount = settLementService.settPayOkCount(uid, null);
        Integer settCanelCount = settLementService.settCanelCount(uid, null);
        Integer settPayFaildCount = settLementService.settPayFaildCount(uid, null);
        model.addAttribute("settCountAll", settCountAll);
        model.addAttribute("settPayOkCount", settPayOkCount);
        model.addAttribute("settCanelCount", settCanelCount);
        model.addAttribute("settPayFaildCount", settPayFaildCount);
        BigDecimal money1 = settLementService.settPayMoney(uid, 2, null);
        BigDecimal money2 = settLementService.settPaySubMoney(uid, 2, null);
        BigDecimal money3 = settLementService.settPayMoney(uid, 4, null);
        BigDecimal money4 = settLementService.settPaySubMoney(uid, 4, null);
        model.addAttribute("money1", money1);
        model.addAttribute("money2", money2);
        model.addAttribute("money3", money3);
        model.addAttribute("money4", money4);
        BigDecimal tmp1 = settLementService.settPayMoney(uid, 1, null);
        BigDecimal tmp2 = settLementService.settPayMoney(uid, 3, null);
        tmp1 = tmp1 == null ? new BigDecimal("0.00") : tmp1;
        tmp2 = tmp2 == null ? new BigDecimal("0.00") : tmp2;
        model.addAttribute("money5", tmp1.add(tmp2));
        BigDecimal dec1 = settLementService.settPaySubMoney(uid, 1, null);
        BigDecimal dec2 = settLementService.settPaySubMoney(uid, 3, null);
        dec1 = dec1 == null ? new BigDecimal("0.00") : dec1;
        dec2 = dec2 == null ? new BigDecimal("0.00") : dec2;
        model.addAttribute("money6", dec1.add(dec2));
        return "admin/count/history_all";
    }

    /**
     * 系统今日统计
     */
    @RequiresPermissions("sys_count_history")
    @RequestMapping("/sys_today")
    public String sys_today(HttpSession session, Model model) throws Exception {
        SystemUser user = (SystemUser) session.getAttribute("userInfo");
        if (user.getRole() != 1) {
            return "forward:/error";
        }
        String today = time.format(new Date());
        Integer settCountAll = settLementService.settCountAll(null, time.parse(today));
        Integer settPayOkCount = settLementService.settPayOkCount(null, time.parse(today));
        Integer settCanelCount = settLementService.settCanelCount(null, time.parse(today));
        Integer settPayFaildCount = settLementService.settPayFaildCount(null, time.parse(today));
        model.addAttribute("settCountAll", settCountAll);
        model.addAttribute("settPayOkCount", settPayOkCount);
        model.addAttribute("settCanelCount", settCanelCount);
        model.addAttribute("settPayFaildCount", settPayFaildCount);
        BigDecimal money1 = settLementService.settPayMoney(null, 2, today);
        BigDecimal money2 = settLementService.settPaySubMoney(null, 2, today);
        BigDecimal money3 = settLementService.settPayMoney(null, 4, today);
        BigDecimal money4 = settLementService.settPaySubMoney(null, 4, today);
        model.addAttribute("money1", money1);
        model.addAttribute("money2", money2);
        model.addAttribute("money3", money3);
        model.addAttribute("money4", money4);
        BigDecimal tmp1 = settLementService.settPayMoney(null, 1, today);
        BigDecimal tmp2 = settLementService.settPayMoney(null, 3, today);
        tmp1 = tmp1 == null ? new BigDecimal("0.00") : tmp1;
        tmp2 = tmp2 == null ? new BigDecimal("0.00") : tmp2;
        model.addAttribute("money5", tmp1.add(tmp2));
        BigDecimal dec1 = settLementService.settPaySubMoney(null, 1, today);
        BigDecimal dec2 = settLementService.settPaySubMoney(null, 3, today);
        dec1 = dec1 == null ? new BigDecimal("0.00") : dec1;
        dec2 = dec2 == null ? new BigDecimal("0.00") : dec2;
        model.addAttribute("money6", dec1.add(dec2));
        Integer order1 = countService.todayCreateOrder(null, null, today, null);
        Integer order2 = countService.todayCreateOrder(null, null, today, 3);
        Integer order3 = countService.todayCreateOrder(null, null, today, 1);
        Integer order4 = countService.todayCreateOrder(null, 2, today, null);
        Integer order5 = countService.todayCreateOrder(null, 1, today, null);
        Integer order9 = countService.todayCreateOrder(null, 3, today, null);
        BigDecimal order6 = countService.todayOrderSettMoneyCount(null, 2, today);
        model.addAttribute("order1", order1);
        model.addAttribute("order2", order2);
        model.addAttribute("order3", order3);
        model.addAttribute("order4", order4);
        model.addAttribute("order5", order5);
        model.addAttribute("order6", order6);
        model.addAttribute("order9", order9);
        BigDecimal moneyCount1 = countService.todayOrderMoneyCount(null, 2, today);
        BigDecimal moneyCount2 = countService.todayOrderMoneyCount(null, 1, today);
        BigDecimal moneyCount3 = countService.todayOrderMoneyCount(null, 3, today);
        model.addAttribute("moneyCount1", moneyCount1);
        model.addAttribute("moneyCount2", moneyCount2);
        model.addAttribute("moneyCount3", moneyCount3);
        Integer order_wx_count = orderService.countOrderPayType(1, time.parse(today));
        Integer order_alipay_count = orderService.countOrderPayType(2, time.parse(today));
        Integer order_qq_count = orderService.countOrderPayType(3, time.parse(today));
        model.addAttribute("order_wx_count", order_wx_count);
        model.addAttribute("order_alipay_count", order_alipay_count);
        model.addAttribute("order_qq_count", order_qq_count);
        BigDecimal wx_out = countService.ptMoneyCountByType(1, today);
        BigDecimal alipay_out = countService.ptMoneyCountByType(2, today);
        BigDecimal changeSett = countService.ptMoneyInByChangeSett(today);
        BigDecimal register = countService.ptMoneyInByRegister(today);
        BigDecimal settOut = countService.ptMoneyInBySettOut(today);
        BigDecimal type1 = countService.ptMoneyInByOrderPayType(today, 1);
        BigDecimal type2 = countService.ptMoneyInByOrderPayType(today, 2);
        BigDecimal type3 = countService.ptMoneyInByOrderPayType(today, 3);
        model.addAttribute("wx_out", wx_out);
        model.addAttribute("alipay_out", alipay_out);
        model.addAttribute("changeSett", changeSett);
        model.addAttribute("register", register);
        model.addAttribute("settOut", settOut);
        model.addAttribute("type1", type1);
        model.addAttribute("type2", type2);
        model.addAttribute("type3", type3);
        return "admin/count/sys_today";
    }

    /**
     * 系统全部统计
     */
    @RequiresPermissions("sys_count_history")
    @RequestMapping("/sys_all")
    public String sys_all(HttpSession session, Model model, String date) {
        Integer settCountAll = settLementService.settCountAll(null, null);
        Integer settPayOkCount = settLementService.settPayOkCount(null, null);
        Integer settCanelCount = settLementService.settCanelCount(null, null);
        Integer settPayFaildCount = settLementService.settPayFaildCount(null, null);
        model.addAttribute("settCountAll", settCountAll);
        model.addAttribute("settPayOkCount", settPayOkCount);
        model.addAttribute("settCanelCount", settCanelCount);
        model.addAttribute("settPayFaildCount", settPayFaildCount);
        BigDecimal money1 = settLementService.settPayMoney(null, 2, null);
        BigDecimal money2 = settLementService.settPaySubMoney(null, 2, null);
        BigDecimal money3 = settLementService.settPayMoney(null, 4, null);
        BigDecimal money4 = settLementService.settPaySubMoney(null, 4, null);
        model.addAttribute("money1", money1);
        model.addAttribute("money2", money2);
        model.addAttribute("money3", money3);
        model.addAttribute("money4", money4);
        BigDecimal tmp1 = settLementService.settPayMoney(null, 1, null);
        BigDecimal tmp2 = settLementService.settPayMoney(null, 3, null);
        tmp1 = tmp1 == null ? new BigDecimal("0.00") : tmp1;
        tmp2 = tmp2 == null ? new BigDecimal("0.00") : tmp2;
        model.addAttribute("money5", tmp1.add(tmp2));
        BigDecimal dec1 = settLementService.settPaySubMoney(null, 1, null);
        BigDecimal dec2 = settLementService.settPaySubMoney(null, 3, null);
        dec1 = dec1 == null ? new BigDecimal("0.00") : dec1;
        dec2 = dec2 == null ? new BigDecimal("0.00") : dec2;
        model.addAttribute("money6", dec1.add(dec2));
        Integer order1 = countService.todayCreateOrder(null, null, null, null);
        Integer order2 = countService.todayCreateOrder(null, null, null, 3);
        Integer order3 = countService.todayCreateOrder(null, null, null, 1);
        Integer order4 = countService.todayCreateOrder(null, 2, null, null);
        Integer order5 = countService.todayCreateOrder(null, 1, null, null);
        Integer order9 = countService.todayCreateOrder(null, 3, null, null);
        BigDecimal order6 = countService.todayOrderSettMoneyCount(null, 2, null);
        model.addAttribute("order1", order1);
        model.addAttribute("order9", order9);
        model.addAttribute("order2", order2);
        model.addAttribute("order3", order3);
        model.addAttribute("order4", order4);
        model.addAttribute("order5", order5);
        model.addAttribute("order6", order6);
        BigDecimal moneyCount1 = countService.todayOrderMoneyCount(null, 2, null);
        BigDecimal moneyCount2 = countService.todayOrderMoneyCount(null, 1, null);
        BigDecimal moneyCount3 = countService.todayOrderMoneyCount(null, 3, null);
        model.addAttribute("moneyCount1", moneyCount1);
        model.addAttribute("moneyCount2", moneyCount2);
        model.addAttribute("moneyCount3", moneyCount3);
        Integer order_wx_count = orderService.countOrderPayType(1, null);
        Integer order_alipay_count = orderService.countOrderPayType(2, null);
        Integer order_qq_count = orderService.countOrderPayType(3, null);
        model.addAttribute("order_wx_count", order_wx_count);
        model.addAttribute("order_alipay_count", order_alipay_count);
        model.addAttribute("order_qq_count", order_qq_count);
        BigDecimal wx_out = countService.ptMoneyCountByType(1, null);
        BigDecimal alipay_out = countService.ptMoneyCountByType(2, null);
        BigDecimal changeSett = countService.ptMoneyInByChangeSett(null);
        BigDecimal register = countService.ptMoneyInByRegister(null);
        BigDecimal settOut = countService.ptMoneyInBySettOut(null);
        BigDecimal type1 = countService.ptMoneyInByOrderPayType(null, 1);
        BigDecimal type2 = countService.ptMoneyInByOrderPayType(null, 2);
        BigDecimal type3 = countService.ptMoneyInByOrderPayType(null, 3);
        model.addAttribute("wx_out", wx_out);
        model.addAttribute("alipay_out", alipay_out);
        model.addAttribute("changeSett", changeSett);
        model.addAttribute("register", register);
        model.addAttribute("settOut", settOut);
        model.addAttribute("type1", type1);
        model.addAttribute("type2", type2);
        model.addAttribute("type3", type3);
        Integer all = 0;
        Integer reg = 0;
        List<SystemUser> user_list = userService.find_user_list();
        if (user_list != null) {
            all = user_list.size();
        }
        List<SystemUser> user_list2 = userService.find_user_list2(1);
        if (user_list2 != null) {
            reg = user_list2.size();
        }
        model.addAttribute("all_user", all);
        model.addAttribute("reg", reg);
        model.addAttribute("hzuser", all - reg);
        CountRet first = countService.findUserFirst();
        model.addAttribute("first", first);
        return "admin/count/sys_all";
    }


    /**
     * 今日统计 - 按用户查询
     */
    @RequiresPermissions("sys_count_user_query")
    @RequestMapping("/today_query")
    public String inCount_query(Integer pid, Model model, String date, HttpSession session) {
        if (pid == null) {
            pid = ((SystemUser) session.getAttribute("userInfo")).getId();
        }
        String today;
        if (date != null && date.length() > 5) {
            today = date;
        } else {
            today = time.format(new Date());
        }
        model.addAttribute("pid", pid);
        model.addAttribute("date", today);
        SystemUser user = userService.findUserById(pid);
        Integer uid = user.getId();
        BigDecimal todayInMoney = countService.todayInMoney(uid, today);
        BigDecimal todaySettMoney = countService.todaySettMoney(uid, today);
        BigDecimal todayChangeMoneySett = countService.todayChangeMoneySett(uid, today);
        BigDecimal todayWaitSettMoney = countService.todayWaitSettMoney(uid, today);
        model.addAttribute("login_user", userService.findUserById(user.getId()));
        model.addAttribute("todayInMoney", todayInMoney);
        model.addAttribute("todaySettMoney", todaySettMoney);
        model.addAttribute("todayChangeMoneySett", todayChangeMoneySett);
        model.addAttribute("todayWaitSettMoney", todayWaitSettMoney);
        Integer order1 = countService.todayCreateOrder(uid, null, today, null);
        Integer order2 = countService.todayCreateOrder(uid, null, today, 3);
        Integer order3 = countService.todayCreateOrder(uid, null, today, 1);
        Integer order4 = countService.todayCreateOrder(uid, 2, today, null);
        Integer order5 = countService.todayCreateOrder(uid, 1, today, null);
        Integer order9 = countService.todayCreateOrder(uid, 3, today, null);
        BigDecimal order6 = countService.todayOrderSettMoneyCount(uid, 2, today);
        model.addAttribute("order1", order1);
        model.addAttribute("order2", order2);
        model.addAttribute("order3", order3);
        model.addAttribute("order4", order4);
        model.addAttribute("order5", order5);
        model.addAttribute("order6", order6);
        model.addAttribute("order9", order9);
        BigDecimal moneyCount1 = countService.todayOrderMoneyCount(uid, 2, today);
        BigDecimal moneyCount2 = countService.todayOrderMoneyCount(uid, 1, today);
        BigDecimal moneyCount3 = countService.todayOrderMoneyCount(uid, 3, today);
        model.addAttribute("moneyCount3", moneyCount3);
        model.addAttribute("moneyCount1", moneyCount1);
        model.addAttribute("moneyCount2", moneyCount2);
        return "admin/count/today_query";
    }


    /**
     * 全部数据 - 按用户查询
     */
    @RequiresPermissions("sys_count_user_history_query")
    @RequestMapping("/history_all_query")
    public String outCount_query(Integer pid, Model model, HttpSession session) {
        if (pid == null) {
            pid = ((SystemUser) session.getAttribute("userInfo")).getId();
        }
        SystemUser user = userService.findUserById(pid);
        model.addAttribute("pid", pid);
        Integer uid = user.getId();
        BigDecimal todayInMoney = countService.todayInMoney(uid, null);
        BigDecimal todaySettMoney = countService.todaySettMoney(uid, null);
        BigDecimal todayChangeMoneySett = countService.todayChangeMoneySett(uid, null);
        BigDecimal todayWaitSettMoney = countService.todayWaitSettMoney(uid, null);
        model.addAttribute("login_user", userService.findUserById(user.getId()));
        model.addAttribute("todayInMoney", todayInMoney);
        model.addAttribute("todaySettMoney", todaySettMoney);
        model.addAttribute("todayChangeMoneySett", todayChangeMoneySett);
        model.addAttribute("todayWaitSettMoney", todayWaitSettMoney);
        Integer order1 = countService.todayCreateOrder(uid, null, null, null);
        Integer order2 = countService.todayCreateOrder(uid, null, null, 3);
        Integer order3 = countService.todayCreateOrder(uid, null, null, 1);
        Integer order4 = countService.todayCreateOrder(uid, 2, null, null);
        Integer order5 = countService.todayCreateOrder(uid, 1, null, null);
        Integer order9 = countService.todayCreateOrder(uid, 3, null, null);
        BigDecimal order6 = countService.todayOrderSettMoneyCount(uid, 2, null);
        model.addAttribute("order1", order1);
        model.addAttribute("order2", order2);
        model.addAttribute("order3", order3);
        model.addAttribute("order4", order4);
        model.addAttribute("order5", order5);
        model.addAttribute("order6", order6);
        model.addAttribute("order9", order9);
        BigDecimal moneyCount1 = countService.todayOrderMoneyCount(uid, 2, null);
        BigDecimal moneyCount2 = countService.todayOrderMoneyCount(uid, 1, null);
        BigDecimal moneyCount3 = countService.todayOrderMoneyCount(uid, 3, null);
        model.addAttribute("moneyCount1", moneyCount1);
        model.addAttribute("moneyCount3", moneyCount3);
        model.addAttribute("moneyCount2", moneyCount2);
        Integer settCountAll = settLementService.settCountAll(uid, null);
        Integer settPayOkCount = settLementService.settPayOkCount(uid, null);
        Integer settCanelCount = settLementService.settCanelCount(uid, null);
        Integer settPayFaildCount = settLementService.settPayFaildCount(uid, null);
        model.addAttribute("settCountAll", settCountAll);
        model.addAttribute("settPayOkCount", settPayOkCount);
        model.addAttribute("settCanelCount", settCanelCount);
        model.addAttribute("settPayFaildCount", settPayFaildCount);
        BigDecimal money1 = settLementService.settPayMoney(uid, 2, null);
        BigDecimal money2 = settLementService.settPaySubMoney(uid, 2, null);
        BigDecimal money3 = settLementService.settPayMoney(uid, 4, null);
        BigDecimal money4 = settLementService.settPaySubMoney(uid, 4, null);
        model.addAttribute("money1", money1);
        model.addAttribute("money2", money2);
        model.addAttribute("money3", money3);
        model.addAttribute("money4", money4);
        BigDecimal tmp1 = settLementService.settPayMoney(uid, 1, null);
        BigDecimal tmp2 = settLementService.settPayMoney(uid, 3, null);
        tmp1 = tmp1 == null ? new BigDecimal("0.00") : tmp1;
        tmp2 = tmp2 == null ? new BigDecimal("0.00") : tmp2;
        model.addAttribute("money5", tmp1.add(tmp2));
        BigDecimal dec1 = settLementService.settPaySubMoney(uid, 1, null);
        BigDecimal dec2 = settLementService.settPaySubMoney(uid, 3, null);
        dec1 = dec1 == null ? new BigDecimal("0.00") : dec1;
        dec2 = dec2 == null ? new BigDecimal("0.00") : dec2;
        model.addAttribute("money6", dec1.add(dec2));
        return "admin/count/history_all_query";
    }

}
