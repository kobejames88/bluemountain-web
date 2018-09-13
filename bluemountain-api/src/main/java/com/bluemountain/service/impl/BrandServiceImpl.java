/****************************************************
 * Description: ServiceImpl for 品牌表
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;


import com.bluemountain.business.brand.dao.BrandDao;
import com.bluemountain.business.brand.entity.BrandEntity;

import com.bluemountain.service.BrandService;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.service.XjjServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl extends XjjServiceSupport<BrandEntity> implements BrandService {

	@Autowired
	private BrandDao brandDao;

	@Override
	public XjjDAO<BrandEntity> getDao() {
		
		return brandDao;
	}
}