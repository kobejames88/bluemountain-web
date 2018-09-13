/****************************************************
 * Description: DAO for 角色
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-04-18 zhanghejie Create File
**************************************************/
package com.bluemountain.sec.dao;


import com.bluemountain.sec.entity.RoleEntity;
import com.bluemountain.sec.entity.RolePrivilegeEntity;
import com.bluemoutain.dao.XjjDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleDao  extends XjjDAO<RoleEntity> {
	
	public List<RoleEntity> findListNoUser(@Param("userId") Long userId);
	
	public RoleEntity getByCode(@Param("code") String code);
	
	public List<RolePrivilegeEntity> findPrivilegeByRole(@Param("roleId") Long roleId);
	
	public List<RoleEntity> findListByUserId(@Param("userId") Long userId);
}

