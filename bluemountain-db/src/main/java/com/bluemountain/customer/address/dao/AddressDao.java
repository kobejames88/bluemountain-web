/****************************************************
 * Description: DAO for 地址
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/
package com.bluemountain.customer.address.dao;


import com.bluemountain.customer.address.entity.AddressEntity;
import com.bluemoutain.dao.XjjDAO;
import org.apache.ibatis.annotations.Param;

public interface AddressDao  extends XjjDAO<AddressEntity> {
	
	public void resetDefault(@Param("customerId") Long customerId);
}

