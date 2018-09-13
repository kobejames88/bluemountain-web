/****************************************************
 * Description: ServiceImpl for 广告
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;



import com.bluemountain.business.ad.dao.AdDao;
import com.bluemountain.business.ad.entity.AdEntity;
import com.bluemountain.service.AdService;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.service.XjjServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdServiceImpl extends XjjServiceSupport<AdEntity> implements AdService {

	@Autowired
	private AdDao adDao;

	@Override
	public XjjDAO<AdEntity> getDao() {
		
		return adDao;
	}
	
	
	
}