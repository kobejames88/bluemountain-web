/****************************************************
 * Description: ServiceImpl for 客户
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;


import com.bluemountain.customer.buyer.dao.BuyerDao;
import com.bluemountain.customer.buyer.entity.BuyerEntity;
import com.bluemountain.service.BuyerService;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.service.XjjServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BuyerServiceImpl extends XjjServiceSupport<BuyerEntity> implements BuyerService {

	@Autowired
	private BuyerDao buyerDao;

	@Override
	public XjjDAO<BuyerEntity> getDao() {
		
		return buyerDao;
	}
	
	public BuyerEntity getByOpenId(String openId)
	{
		List<BuyerEntity> list = buyerDao.findListByColumn("wxOpenid", openId);
		
		if(null==list || list.size()==0)
		{
			return null;
		}
		return list.get(0);
	}
}