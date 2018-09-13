package com.bluemoutain.mapper;


import com.bluemoutain.po.SysRoleFunction;
import com.bluemoutain.po.SysRoleFunctionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysRoleFunctionMapper {
    long countByExample(SysRoleFunctionExample example);

    int deleteByExample(SysRoleFunctionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysRoleFunction record);

    int insertSelective(SysRoleFunction record);

    List<SysRoleFunction> selectByExample(SysRoleFunctionExample example);

    SysRoleFunction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysRoleFunction record, @Param("example") SysRoleFunctionExample example);

    int updateByExample(@Param("record") SysRoleFunction record, @Param("example") SysRoleFunctionExample example);

    int updateByPrimaryKeySelective(SysRoleFunction record);

    int updateByPrimaryKey(SysRoleFunction record);
}