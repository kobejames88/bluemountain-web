/****************************************************
 * Description: Service for 订单商品
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/
package com.bluemountain.service;



import com.bluemountain.customer.order.entity.OrderGoodsEntity;
import com.bluemoutain.service.XjjService;

import java.util.List;

public interface OrderGoodsService  extends XjjService<OrderGoodsEntity> {
	
	public List<OrderGoodsEntity> findByOidAndGid(Long orderId, Long goodsId);
}
