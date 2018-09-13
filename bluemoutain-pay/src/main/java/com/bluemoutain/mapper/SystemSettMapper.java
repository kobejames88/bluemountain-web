package com.bluemoutain.mapper;

import com.bluemoutain.po.SystemSett;
import com.bluemoutain.po.SystemSettExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemSettMapper {
    long countByExample(SystemSettExample example);

    int deleteByExample(SystemSettExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemSett record);

    int insertSelective(SystemSett record);

    List<SystemSett> selectByExample(SystemSettExample example);

    SystemSett selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemSett record, @Param("example") SystemSettExample example);

    int updateByExample(@Param("record") SystemSett record, @Param("example") SystemSettExample example);

    int updateByPrimaryKeySelective(SystemSett record);

    int updateByPrimaryKey(SystemSett record);
}