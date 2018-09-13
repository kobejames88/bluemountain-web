/****************************************************
 * Description: ServiceImpl for 收藏
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-11 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;


import com.bluemountain.customer.collect.dao.CollectDao;
import com.bluemountain.customer.collect.entity.CollectEntity;
import com.bluemountain.service.CollectService;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.service.XjjServiceSupport;
import com.bluemoutain.web.support.XJJParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CollectServiceImpl extends XjjServiceSupport<CollectEntity> implements CollectService {

	@Autowired
	private CollectDao collectDao;

	@Override
	public XjjDAO<CollectEntity> getDao() {
		
		return collectDao;
	}
	
	public int getCountByUserIdAndValueId(Long customerId,Long valueId)
	{
		XJJParameter param = new XJJParameter();
		param.addQuery("query.customerId@eq@l", customerId);
        param.addQuery("query.valueId@eq@l", valueId);
        int count = collectDao.getCount(param.getQueryMap());
        return count;
	}
	
	public CollectEntity getByTypeAndValue(Long customerId, Integer type, Long valueId)
	{
		XJJParameter param = new XJJParameter();
		param.addQuery("query.customerId@eq@l", customerId);
		param.addQuery("query.typeId@eq@i", type);
        param.addQuery("query.valueId@eq@l", valueId);
        List<CollectEntity> list = collectDao.findList(param.getQueryMap());
        
        if(null==list || list.size()==0)
        {
        	return null;
        }
        return list.get(0);
	}
}