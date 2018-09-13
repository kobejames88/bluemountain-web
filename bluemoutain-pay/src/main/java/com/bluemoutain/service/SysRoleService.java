package com.bluemoutain.service;



import com.bluemoutain.po.SysRole;
import com.bluemoutain.po.ext.SysRoleExt;
import com.bluemoutain.utils.PageBean;

import java.util.List;


public interface SysRoleService {

    SysRole findById(Integer id);

    SysRole save(SysRole role, String menuIds);

    SysRole update(SysRole role, String menuIds);

    int delete(Integer id);

    PageBean<SysRole> findByPage(Integer pageNum, Integer rows);

    Boolean roleIsHavingFunction(Integer id, Integer id1);

    List<SysRole> findAllRoles();

    SysRoleExt findAllFunctionByRole(Integer role_id);

}
