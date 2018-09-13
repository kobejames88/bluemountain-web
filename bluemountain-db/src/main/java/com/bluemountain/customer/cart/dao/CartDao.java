/****************************************************
 * Description: DAO for 购物车
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/
package com.bluemountain.customer.cart.dao;


import com.bluemountain.customer.cart.entity.CartEntity;
import com.bluemoutain.dao.XjjDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CartDao  extends XjjDAO<CartEntity> {
	public int updateCheck(@Param("userId") Long userId, @Param("productIds") List<Long> productIds, @Param("checked") Integer checked);
	public void deleteByProductId(@Param("userId") Long userId, @Param("productIds") List<Long> productIds);
	
	public void clearGoods(@Param("userId") Long userId);
}