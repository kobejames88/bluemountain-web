package com.bluemoutain.controller.mobile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * APP接口 API
 */
@RestController
@RequestMapping("/mApiInterFace")
public class MobileAPIController {

    /**
     * APP  - 首页
     */
    @RequestMapping("/home")
    @ResponseBody
    public Map home() {
        HashMap<Object, Object> ret = new HashMap<>();

        ret.put("code", 0);
        ret.put("msg", "获取成功!");
        return ret;
    }

    /**
     * APP  - 订单
     */
    @RequestMapping("/order_list")
    @ResponseBody
    public Map order_list() {
        HashMap<Object, Object> ret = new HashMap<>();

        ret.put("code", 0);
        ret.put("msg", "获取成功!");
        return ret;
    }


}
