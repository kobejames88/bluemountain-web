/****************************************************
 * Description: DAO for 用户角色
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-04-18 zhanghejie Create File
**************************************************/
package com.bluemountain.sec.dao;


import com.bluemountain.sec.entity.UserRoleEntity;
import com.bluemoutain.dao.XjjDAO;
import org.apache.ibatis.annotations.Param;

public interface UserRoleDao  extends XjjDAO<UserRoleEntity> {
	public void deleteBy2Id(@Param("userId") Long userId, @Param("roleId") Long roleId);
}

