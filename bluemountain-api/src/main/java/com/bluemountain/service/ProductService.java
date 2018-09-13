/****************************************************
 * Description: Service for t_business_product
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-11 zhanghejie Create File
**************************************************/
package com.bluemountain.service;



import com.bluemountain.business.product.entity.ProductEntity;
import com.bluemoutain.service.XjjService;

import java.util.List;

public interface ProductService  extends XjjService<ProductEntity> {
	
	/**
	 * 根据商品id查询product列表
	 * @param goodsId
	 * @return
	 */
	public List<ProductEntity> findListByGoodsId(Long goodsId); 
}
