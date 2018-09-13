/****************************************************
 * Description: Service for t_business_goods_attribute
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-11 zhanghejie Create File
**************************************************/
package com.bluemountain.service;



import com.bluemountain.business.goods.entity.GoodsAttributeEntity;
import com.bluemoutain.service.XjjService;

import java.util.List;

public interface GoodsAttributeService  extends XjjService<GoodsAttributeEntity> {
	
	/**
	 * 根据商品id查询属性列表
	 * @param goodsId
	 * @return
	 */
	public List<GoodsAttributeEntity> findListByGoodsId(Long goodsId); 

}
