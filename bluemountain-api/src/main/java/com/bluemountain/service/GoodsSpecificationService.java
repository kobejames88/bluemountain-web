/****************************************************
 * Description: Service for 商品规格
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/
package com.bluemountain.service;



import com.bluemountain.business.goods.entity.GoodsSpecificationEntity;
import com.bluemoutain.service.XjjService;

import java.util.List;

public interface GoodsSpecificationService  extends XjjService<GoodsSpecificationEntity> {
    /**
     * [
     *  {
     *      name: '',
     *      valueList: [ {}, {}]
     *  },
     *  {
     *      name: '',
     *      valueList: [ {}, {}]
     *  }
     *  ]
     *
     * @param id
     * @return
     */
    public Object getSpecificationVoList(Long id);
    
    /**
	 * 根据商品id查询product列表
	 * @param goodsId
	 * @return
	 */
	public List<GoodsSpecificationEntity> findListByGoodsId(Long goodsId);
}
