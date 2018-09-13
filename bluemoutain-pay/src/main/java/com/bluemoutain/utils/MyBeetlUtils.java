package com.bluemoutain.utils;


import com.bluemoutain.po.SysRole;
import com.bluemoutain.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * beetl 自定义工具类
 */
@Component
public class MyBeetlUtils {

    @Autowired
    private SysRoleService roleService;

    /**
     * 截取字符串
     */
    public String sub_str(String str, Integer start, Integer end) {
        if (str == null) {
            return "";
        }
        if (str.length() > end) {
            return str.substring(start, end);
        } else {
            return str;
        }
    }

    /**
     * 根据id获取角色名称
     */
    public String getRoleName(Integer role_id) {
        SysRole model = roleService.findById(role_id);
        if (model != null) {
            return model.getRoleName();
        }
        return null;
    }

    /**
     * 根据银行代码获取银行名称
     */
    public String getBankName(String code) {
        switch (code) {
            case "1002":
                return "工商银行";
            case "1005":
                return "农业银行";
            case "1026":
                return "中国银行";
            case "1003":
                return "建设银行";
            case "1001":
                return "招商银行";
            case "1066":
                return "邮储银行";
            case "1020":
                return "交通银行";
            case "1004":
                return "浦发银行";
            case "1006":
                return "民生银行";
            case "1009":
                return "兴业银行";
            case "1010":
                return "平安银行";
            case "1021":
                return "中信银行";
            case "1025":
                return "华夏银行";
            case "1027":
                return "广发银行";
            case "1022":
                return "光大银行";
            case "1032":
                return "北京银行";
            case "1056":
                return "宁波银行";
            case "":
                return "";
            default:
                return "错误";
        }
    }

    /**
     * 根据银行代码获取银行名称
     */
    public String getBankName(Integer code) {
        switch (code) {
            case 1002:
                return "工商银行";
            case 1005:
                return "农业银行";
            case 1026:
                return "中国银行";
            case 1003:
                return "建设银行";
            case 1001:
                return "招商银行";
            case 1066:
                return "邮储银行";
            case 1020:
                return "交通银行";
            case 1004:
                return "浦发银行";
            case 1006:
                return "民生银行";
            case 1009:
                return "兴业银行";
            case 1010:
                return "平安银行";
            case 1021:
                return "中信银行";
            case 1025:
                return "华夏银行";
            case 1027:
                return "广发银行";
            case 1022:
                return "光大银行";
            case 1032:
                return "北京银行";
            case 1056:
                return "宁波银行";
            case 0:
                return "输入错误,无法识别!";
            default:
                return "错误";
        }
    }


}
