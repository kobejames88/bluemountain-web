package com.bluemoutain.mapper;

import com.bluemoutain.po.SystemWeb;
import com.bluemoutain.po.SystemWebExample;
import com.bluemoutain.po.SystemWebWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemWebMapper {
    long countByExample(SystemWebExample example);

    int deleteByExample(SystemWebExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemWebWithBLOBs record);

    int insertSelective(SystemWebWithBLOBs record);

    List<SystemWebWithBLOBs> selectByExampleWithBLOBs(SystemWebExample example);

    List<SystemWeb> selectByExample(SystemWebExample example);

    SystemWebWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemWebWithBLOBs record, @Param("example") SystemWebExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemWebWithBLOBs record, @Param("example") SystemWebExample example);

    int updateByExample(@Param("record") SystemWeb record, @Param("example") SystemWebExample example);

    int updateByPrimaryKeySelective(SystemWebWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemWebWithBLOBs record);

    int updateByPrimaryKey(SystemWeb record);
}