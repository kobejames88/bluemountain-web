package com.bluemountain.modules.order.controller;


import com.bluemountain.modules.order.service.OrderGoodService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**order
 *
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 17:20:46
 */
@RestController
@RequestMapping("ordergood")
@Api(tags="订单商品接口")
public class OrderGoodController {
    @Autowired
    private OrderGoodService orderGoodService;

}
