/****************************************************
 * Description: DAO for 菜单
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-04-12 zhanghejie Create File
**************************************************/
package com.bluemountain.sec.dao;


import com.bluemountain.sec.entity.MenuEntity;
import com.bluemoutain.dao.XjjDAO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MenuDao  extends XjjDAO<MenuEntity> {
	
	public List<MenuEntity> findMenusByPid(@Param("pid") Long pid);
}

