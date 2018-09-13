/****************************************************
 * Description: DAO for t_sec_role_privilege
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-04-18 zhanghejie Create File
**************************************************/
package com.bluemountain.sec.dao;

import com.bluemountain.sec.entity.RolePrivilegeEntity;

import com.bluemoutain.dao.XjjDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RolePrivilegeDao  extends XjjDAO<RolePrivilegeEntity> {
	public RolePrivilegeEntity getByRolePri(@Param("roleId") Long roleId, @Param("pcode") String pcode);
	
	/**
	 * 角色查询有权浏览（list）的菜单
	 * @param roleIds
	 * @return
	 */
	public List<RolePrivilegeEntity> findListByRoleHasListPri(@Param("roleIds") Long[] roleIds, @Param("listCode") String listCode);
}

