package com.bluemoutain.controller;

import com.bluemoutain.plugins.pay.YiPayFunction;
import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.service.WebConfigService;
import com.bluemoutain.utils.HttpClientUtils;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Map;

/**
 * 错误处理
 */
@ControllerAdvice
public class BaseErrorController {

    private static Logger logger = LoggerFactory.getLogger(BaseErrorController.class);

    @Autowired
    private WebConfigService webConfigService;

    @Autowired
    private YiPayFunction yiPayFunction;

    @ExceptionHandler(value = Exception.class)
    public String defaultErrorHandler(HttpServletRequest req, Exception e, Model model) {
        logger.info("====================Error Log =====================");
        e.printStackTrace();
        logger.info("====================Error Log =====================");
        model.addAttribute("ecc", e);
        SystemWeb web = webConfigService.find_by_id(1);
        model.addAttribute("config", web);
        Map map = HttpClientUtils.getParameterMap(req);
        String string = yiPayFunction.createLinkString(map);
        String[] split = string.split("&");
        model.addAttribute("para", split);
        model.addAttribute("url", req.getRequestURL());
        logger.error(e.getMessage());
        return "error";
    }


}
