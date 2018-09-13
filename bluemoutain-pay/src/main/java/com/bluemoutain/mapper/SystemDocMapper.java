package com.bluemoutain.mapper;


import com.bluemoutain.po.SystemDoc;
import com.bluemoutain.po.SystemDocExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemDocMapper {
    long countByExample(SystemDocExample example);

    int deleteByExample(SystemDocExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemDoc record);

    int insertSelective(SystemDoc record);

    List<SystemDoc> selectByExampleWithBLOBs(SystemDocExample example);

    List<SystemDoc> selectByExample(SystemDocExample example);

    SystemDoc selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemDoc record, @Param("example") SystemDocExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemDoc record, @Param("example") SystemDocExample example);

    int updateByExample(@Param("record") SystemDoc record, @Param("example") SystemDocExample example);

    int updateByPrimaryKeySelective(SystemDoc record);

    int updateByPrimaryKeyWithBLOBs(SystemDoc record);

    int updateByPrimaryKey(SystemDoc record);
}