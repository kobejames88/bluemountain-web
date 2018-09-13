/****************************************************
 * Description: ServiceImpl for 商家
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;

import com.xjj.framework.dao.XjjDAO;
import com.xjj.framework.service.XjjServiceSupport;
import com.xjj.wefactory.business.seller.dao.SellerDao;
import com.xjj.wefactory.business.seller.entity.SellerEntity;
import com.xjj.wefactory.wx.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SellerServiceImpl extends XjjServiceSupport<SellerEntity> implements SellerService {

	@Autowired
	private SellerDao sellerDao;

	@Override
	public XjjDAO<SellerEntity> getDao() {
		
		return sellerDao;
	}
}