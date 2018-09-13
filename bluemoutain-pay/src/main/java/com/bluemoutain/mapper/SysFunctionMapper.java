package com.bluemoutain.mapper;


import com.bluemoutain.po.SysFunction;
import com.bluemoutain.po.SysFunctionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysFunctionMapper {
    long countByExample(SysFunctionExample example);

    int deleteByExample(SysFunctionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysFunction record);

    int insertSelective(SysFunction record);

    List<SysFunction> selectByExample(SysFunctionExample example);

    SysFunction selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    int updateByExample(@Param("record") SysFunction record, @Param("example") SysFunctionExample example);

    int updateByPrimaryKeySelective(SysFunction record);

    int updateByPrimaryKey(SysFunction record);
}