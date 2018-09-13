package com.bluemoutain.utils;


import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemUser;
import com.bluemoutain.po.SystemWebWithBLOBs;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 支付工具类
 */
@Component
public class PayUtils {

    /**
     * 成订单id
     */
    public static String genOrderId() {
        StringBuilder sb = new StringBuilder();
        String s1 = new SimpleDateFormat("yyyyMMddHms").format(new Date());
        sb.append(s1);
        sb.append((System.currentTimeMillis() + ""));
        return sb.toString();
    }

    /**
     * 选择支付类型
     */
    public static String switchPayType(Integer type) {
        switch (type) {
            case 1:
                return "wxpay";
            case 2:
                return "alipay";
            case 3:
                return "qqpay";
            default:
                return "none";
        }
    }

    /**
     * 选择支付类型
     */
    public static Integer switchPayType2(String type) {
        switch (type) {
            case "wxpay":
                return 1;
            case "alipay":
                return 2;
            case "qqpay":
                return 3;
            default:
                return 0;
        }
    }

    /**
     * 判断是不是手机
     */
    private static boolean isMobileDevice(String userAgent) {
        if (null == userAgent) {
            userAgent = "";
        }
        Matcher matcherPhone = phonePat.matcher(userAgent);
        Matcher matcherTable = tablePat.matcher(userAgent);
        return matcherPhone.find() || matcherTable.find();

    }

    private static String phoneReg = "\\bNokia|SAMSUNG|MIDP-2|CLDC1.1|SymbianOS|MAUI|UNTRUSTED/1.0"
            + "|Windows CE|iPhone|iPad|Android|BlackBerry|UCWEB|ucweb|BREW|J2ME|YULONG|YuLong|COOLPAD|TIANYU|TY-"
            + "|K-Touch|Haier|DOPOD|Lenovo|LENOVO|HUAQIN|AIGO-|CTC/1.0"
            + "|CTC/2.0|CMCC|DAXIAN|MOT-|SonyEricsson|GIONEE|HTC|ZTE|HUAWEI|webOS|GoBrowser|IEMobile|WAP2.0\\b";
    private static String tableReg = "\\b(ipad|tablet|(Nexus 7)|up.browser"
            + "|[1-4][0-9]{2}x[1-4][0-9]{2})\\b";
    private static Pattern phonePat = Pattern.compile(phoneReg, Pattern.CASE_INSENSITIVE);
    private static Pattern tablePat = Pattern.compile(tableReg, Pattern.CASE_INSENSITIVE);

    /**
     * 判断是不是微信内
     */
    private static boolean isInWeChat(String userAgent) {
        if (null == userAgent) {
            userAgent = "";
        }
        userAgent = userAgent.toLowerCase();
        return userAgent.indexOf("micromessenger") > 0;
    }

    /**
     * 跳转相关支付方法 - 充值/体验接口/开通会员接口
     */
    public static String switchPayMethod2(HttpServletRequest request, SystemOrder order, SystemWebWithBLOBs web) throws Exception {
        Integer oid = order.getId();
        String header = request.getHeader("user-agent");
        if (order.getPayType() == 2) {//支付宝支付
            if (web.getPayToAlipay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (web.getPayToAlipay() == 0) {
                return "/payment/alipay?id=" + oid + "&isMobile=" + isMobileDevice(header);
            } else if (web.getPayToAlipay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        } else if (order.getPayType() == 1) {//微信支付
            if (web.getPayToWxpay() == 0) {
                boolean mobileDevice = isMobileDevice(header);
                if (mobileDevice) {
                    if (isInWeChat(header)) {
                        return "/payment/payInWeChat?id=" + oid;
                    } else {
                        return "/payment/wap_wx_pay?id=" + oid;
                    }
                } else {
                    return "/payment/wxspay?id=" + oid;
                }
            } else if (web.getPayToWxpay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (web.getPayToWxpay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        } else if (order.getPayType() == 3) { //qq支付
            if (web.getPayToQqpay() == 0) {
                return "/payment/qqpayScanCode?id=" + oid;
            } else if (web.getPayToQqpay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (web.getPayToQqpay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        }
        return "/payment/switch?id=" + oid;
    }

    /**
     * 跳转相关支付方法  - 系统API接口
     */
    public static String switchPayMethod_API(HttpServletRequest request, SystemOrder order, SystemUser user) throws Exception {
        Integer oid = order.getId();
        String header = request.getHeader("user-agent");
        if (order.getPayType() == 2) {//支付宝支付
            if (user.getPayAlipay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (user.getPayAlipay() == 0) {
                return "/payment/alipay?id=" + oid + "&isMobile=" + isMobileDevice(header);
            } else if (user.getPayAlipay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        } else if (order.getPayType() == 1) {//微信支付
            if (user.getPayWxpay() == 0) {
                boolean mobileDevice = isMobileDevice(header);
                if (mobileDevice) {
                    if (isInWeChat(header)) {
                        return "/payment/payInWeChat?id=" + oid;
                    } else {
                        return "/payment/wap_wx_pay?id=" + oid;
                    }
                } else {
                    return "/payment/wxspay?id=" + oid;
                }
            } else if (user.getPayWxpay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (user.getPayWxpay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        } else if (order.getPayType() == 3) { //qq支付
            if (user.getPayQqpay() == 0) {
                return "/payment/qqpayScanCode?id=" + oid;
            } else if (user.getPayQqpay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (user.getPayQqpay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        }
        return "/payment/switch?id=" + oid;
    }

    /**
     * 跳转相关支付方法  - 系统API接口
     */
    public static String switchPayMethod_test(HttpServletRequest request, SystemOrder order, SystemWebWithBLOBs web) throws Exception {
        Integer oid = order.getId();
        String header = request.getHeader("user-agent");
        if (order.getPayType() == 2) {//支付宝支付
            if (web.getTestAlipay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (web.getTestAlipay() == 0) {
                return "/payment/alipay?id=" + oid + "&isMobile=" + isMobileDevice(header);
            } else if (web.getTestAlipay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        } else if (order.getPayType() == 1) {//微信支付
            if (web.getTestWxpay() == 0) {
                boolean mobileDevice = isMobileDevice(header);
                if (mobileDevice) {
                    if (isInWeChat(header)) {
                        return "/payment/payInWeChat?id=" + oid;
                    } else {
                        return "/payment/wap_wx_pay?id=" + oid;
                    }
                } else {
                    return "/payment/wxspay?id=" + oid;
                }
            } else if (web.getTestWxpay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (web.getTestWxpay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        } else if (order.getPayType() == 3) { //qq支付
            if (web.getTestQqpay() == 0) {
                return "/payment/qqpayScanCode?id=" + oid;
            } else if (web.getTestQqpay() == 1) {
                return "/payment/yipay?id=" + oid;
            } else if (web.getTestQqpay() == 2) {
                return "/payment/code_pay?id=" + oid;
            } else {
                throw new Exception("当前接口已关闭支付功能,请稍后重试!");
            }
        }
        return "/payment/switch?id=" + oid;
    }

    /**
     * 获取转账失败详细信息
     */
    public static String getSettPayErrorDeitl(String error_code) {
        if (error_code != null) {
            switch (error_code) {
                case "INVALID_PARAMETER":
                    return "参数有误";
                case "SYSTEM_ERROR":
                    return "系统繁忙";
                case "PERMIT_CHECK_PERM_LIMITED":
                    return "根据监管部门的要求，请补全您的身份信息解除限制";
                case "PAYCARD_UNABLE_PAYMENT":
                    return "付款账户余额支付功能不可用";
                case "PAYEE_NOT_EXIST":
                    return "收款账号不存在";
                case "PAYER_DATA_INCOMPLETE":
                    return "根据监管部门的要求，需要付款用户补充身份信息才能继续操作";
                case "PERM_AML_NOT_REALNAME_REV":
                    return "根据监管部门的要求，需要收款用户补充身份信息才能继续操作";
                case "PAYER_STATUS_ERROR":
                    return "付款账号状态异常";
                case "PAYEE_USER_INFO_ERROR":
                    return "支付宝账号和姓名不匹配，请确认姓名是否正确";
                case "PAYER_BALANCE_NOT_ENOUGH":
                    return "付款方余额不足";
                case "PAYMENT_INFO_INCONSISTENCY":
                    return "两次请求商户单号一样，但是参数不一致";
                case "CERT_MISS_TRANS_LIMIT":
                    return "您的付款金额已达单笔1万元或月累计5万元，根据监管部门的要求，需要付款用户补充身份信息才能继续操作";
                case "CERT_MISS_ACC_LIMIT":
                    return "您连续10天余额账户的资金都超过5000元，根据监管部门的要求，需要付款用户补充身份信息才能继续操作";
                case "PAYEE_ACC_OCUPIED":
                    return "该手机号对应多个支付宝账户，请传入收款方姓名确定正确的收款账号";
                case "MEMO_REQUIRED_IN_TRANSFER_ERROR":
                    return "根据监管部门的要求，单笔转账金额达到50000元时，需要填写付款理由";
                case "PERMIT_NON_BANK_LIMIT_PAYEE":
                    return "根据监管部门的要求，对方未完善身份信息或未开立余额账户，无法收款";
                case "PERMIT_PAYER_LOWEST_FORBIDDEN":
                    return "根据监管部门要求，付款方身份信息完整程度较低，余额支付额度受限";
                case "PERMIT_PAYER_FORBIDDEN":
                    return "根据监管部门要求，付款方余额支付额度受限";
                case "PERMIT_CHECK_PERM_IDENTITY_THEFT":
                    return "您的账户存在身份冒用风险，请进行身份核实解除限制";
                case "REMARK_HAS_SENSITIVE_WORD":
                    return "转账备注包含敏感词，请修改备注文案后重试";
                case "ACCOUNT_NOT_EXIST":
                    return "根据监管部门的要求，请补全你的身份信息，开立余额账户";
                case "PAYER_CERT_EXPIRED":
                    return "根据监管部门的要求，需要付款用户更新身份信息才能继续操作";
                case "EXCEED_LIMIT_PERSONAL_SM_AMOUNT":
                    return "转账给个人支付宝账户单笔最多5万元";
                case "EXCEED_LIMIT_ENT_SM_AMOUNT":
                    return "转账给企业支付宝账户单笔最多10万元";
                case "EXCEED_LIMIT_SM_MIN_AMOUNT":
                    return "单笔最低转账金额0.1元";
                case "EXCEED_LIMIT_DM_MAX_AMOUNT":
                    return "单日最多可转100万元";
                case "EXCEED_LIMIT_UNRN_DM_AMOUNT":
                    return "收款账户未实名，单日最多可收款1000元";
                default:
                    return "SUCCESS";
            }
        }
        return null;
    }

    /**
     * 获取当前时间 yyyyMMddHHmmss
     */
    private static String getCurrTime() {
        Date now = new Date();
        SimpleDateFormat outFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        return outFormat.format(now);
    }

    /**
     *  获取随机字符串
     */
    private static int buildRandom(int length) {
        int num = 1;
        double random = Math.random();
        if (random < 0.1) {
            random = random + 0.1;
        }
        for (int i = 0; i < length; i++) {
            num = num * 10;
        }
        return (int) ((random * num));
    }

    /**
     * 微信支付请求,获取随机字符串
     */
    public static String getStrReq() {
        String currTime = getCurrTime();
        String strTime = currTime.substring(8, currTime.length());
        String strRandom = buildRandom(4) + "";
        return strTime + strRandom;
    }

    private static Pattern IP_PATTERN = Pattern.compile("(\\d{1,3}\\.){3}(\\d{1,3})");

    private final static Set<String> PublicSuffixSet = new HashSet<String>(Arrays.asList("com|org|net|gov|cc|top|edu|co|tv|la|mobi|info|asia|xyz|xxx|onion|cn|com.cn|edu.cn|gov.cn|net.cn|org.cn|jp|kr|tw|com.hk|hk|com.hk|org.hk|se|com.se|org.se".split("\\|")));

    /**
     * 获取url的顶级域名
     */
    public static String getDomainName(URL url) {
        String host = url.getHost();
        if (host.endsWith("."))
            host = host.substring(0, host.length() - 1);
        if (IP_PATTERN.matcher(host).matches())
            return host;
        int index = 0;
        String candidate = host;
        for (; index >= 0; ) {
            index = candidate.indexOf('.');
            String subCandidate = candidate.substring(index + 1);
            if (PublicSuffixSet.contains(subCandidate)) {
                return candidate;
            }
            candidate = subCandidate;
        }
        return candidate;
    }

    public static Integer switch_pay_type_code_pay(Integer payType) {
        switch(payType) {
            case 1:
                return 3;
            case 2:
                return 1;
            case 3:
                return 2;
            default:
                return 1;
        }
    }
}
