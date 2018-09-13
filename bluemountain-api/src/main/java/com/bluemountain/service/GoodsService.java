/****************************************************
 * Description: Service for 商品
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/
package com.bluemountain.service;


import com.bluemountain.business.goods.entity.GoodsEntity;
import com.bluemoutain.service.XjjService;

import java.util.List;

public interface GoodsService  extends XjjService<GoodsEntity> {
	
	/**
	 * 查询在售/下架商品总数
	 * @param onSale
	 * @return
	 */
	public int getCountByOnSale(int onSale);
	/**
	 * 查询
	 * @param brandId
	 * @param keyword
	 * @param isHot
	 * @param isNew
	 * @return
	 */
	public List<Long> getCategoryIds(Long brandId, String keyword, Boolean isHot, Boolean isNew);
}
