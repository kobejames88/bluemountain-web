package com.bluemoutain.service;



import com.bluemoutain.po.SysFunction;
import com.bluemoutain.po.ext.SysFunctionExt;

import java.util.List;

public interface SysFunctionService {

    SysFunction find_by_id(Integer id);

    SysFunction saveFunction(SysFunction function);

    SysFunction updateFunction(SysFunction function);

    int delete_by_id(Integer id);

    List<SysFunction> findByParentId(Integer id);

    List<SysFunction> findAllFunctions();

    List<SysFunctionExt> findMenuByRoleId(Integer role_id);

}
