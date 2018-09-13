/****************************************************
 * Description: Service for 客户
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/
package com.bluemountain.service;


import com.bluemountain.customer.buyer.entity.BuyerEntity;
import com.bluemoutain.service.XjjService;

public interface BuyerService  extends XjjService<BuyerEntity> {
	
	/**
	 * 根据openid获得用户
	 * @param openId
	 * @return
	 */
	public BuyerEntity getByOpenId(String openId);
}
