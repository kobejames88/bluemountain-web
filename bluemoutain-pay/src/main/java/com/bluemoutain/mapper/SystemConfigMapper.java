package com.bluemoutain.mapper;


import com.bluemoutain.po.SystemConfig;
import com.bluemoutain.po.SystemConfigExample;
import com.bluemoutain.po.SystemConfigWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemConfigMapper {
    long countByExample(SystemConfigExample example);

    int deleteByExample(SystemConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemConfigWithBLOBs record);

    int insertSelective(SystemConfigWithBLOBs record);

    List<SystemConfigWithBLOBs> selectByExampleWithBLOBs(SystemConfigExample example);

    List<SystemConfig> selectByExample(SystemConfigExample example);

    SystemConfigWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemConfigWithBLOBs record, @Param("example") SystemConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemConfigWithBLOBs record, @Param("example") SystemConfigExample example);

    int updateByExample(@Param("record") SystemConfig record, @Param("example") SystemConfigExample example);

    int updateByPrimaryKeySelective(SystemConfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemConfigWithBLOBs record);

    int updateByPrimaryKey(SystemConfig record);
}