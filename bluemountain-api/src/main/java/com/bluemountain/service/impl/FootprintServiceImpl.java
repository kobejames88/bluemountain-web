/****************************************************
 * Description: ServiceImpl for t_wx.
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;


import com.bluemountain.customer.footprint.dao.FootprintDao;
import com.bluemountain.customer.footprint.entity.FootprintEntity;
import com.bluemountain.service.FootprintService;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.service.XjjServiceSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FootprintServiceImpl extends XjjServiceSupport<FootprintEntity> implements FootprintService {

	@Autowired
	private FootprintDao footprintDao;

	@Override
	public XjjDAO<FootprintEntity> getDao() {
		
		return footprintDao;
	}
}