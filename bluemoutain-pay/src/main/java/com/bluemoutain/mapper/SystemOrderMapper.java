package com.bluemoutain.mapper;


import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemOrderExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemOrderMapper {
    long countByExample(SystemOrderExample example);

    int deleteByExample(SystemOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemOrder record);

    int insertSelective(SystemOrder record);

    List<SystemOrder> selectByExample(SystemOrderExample example);

    SystemOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemOrder record, @Param("example") SystemOrderExample example);

    int updateByExample(@Param("record") SystemOrder record, @Param("example") SystemOrderExample example);

    int updateByPrimaryKeySelective(SystemOrder record);

    int updateByPrimaryKey(SystemOrder record);
}