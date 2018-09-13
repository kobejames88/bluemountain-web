/****************************************************
 * Description: ServiceImpl for 客户优惠券
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;


import com.bluemountain.customer.buyer.dao.BuyerCouponDao;
import com.bluemountain.customer.buyer.entity.BuyerCouponEntity;
import com.bluemountain.service.BuyerCouponService;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.service.XjjServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuyerCouponServiceImpl extends XjjServiceSupport<BuyerCouponEntity> implements BuyerCouponService {

	@Autowired
	private BuyerCouponDao buyerCouponDao;

	@Override
	public XjjDAO<BuyerCouponEntity> getDao() {
		
		return buyerCouponDao;
	}
}