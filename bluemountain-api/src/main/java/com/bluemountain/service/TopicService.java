/****************************************************
 * Description: Service for 专题
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/
package com.bluemountain.service;



import com.bluemountain.business.topic.entity.TopicEntity;
import com.bluemoutain.service.XjjService;

import java.util.List;

public interface TopicService  extends XjjService<TopicEntity> {
	/**
	 * 查询相关专题
	 * @param id
	 * @param offset
	 * @param limit
	 * @return
	 */
	public List<TopicEntity> findRelatedList(Long id, int offset, int limit);
}
