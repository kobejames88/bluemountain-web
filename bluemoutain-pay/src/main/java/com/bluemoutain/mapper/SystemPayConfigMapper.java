package com.bluemoutain.mapper;


import com.bluemoutain.po.SystemPayConfig;
import com.bluemoutain.po.SystemPayConfigExample;
import com.bluemoutain.po.SystemPayConfigWithBLOBs;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemPayConfigMapper {
    long countByExample(SystemPayConfigExample example);

    int deleteByExample(SystemPayConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemPayConfigWithBLOBs record);

    int insertSelective(SystemPayConfigWithBLOBs record);

    List<SystemPayConfigWithBLOBs> selectByExampleWithBLOBs(SystemPayConfigExample example);

    List<SystemPayConfig> selectByExample(SystemPayConfigExample example);

    SystemPayConfigWithBLOBs selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemPayConfigWithBLOBs record, @Param("example") SystemPayConfigExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemPayConfigWithBLOBs record, @Param("example") SystemPayConfigExample example);

    int updateByExample(@Param("record") SystemPayConfig record, @Param("example") SystemPayConfigExample example);

    int updateByPrimaryKeySelective(SystemPayConfigWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(SystemPayConfigWithBLOBs record);

    int updateByPrimaryKey(SystemPayConfig record);
}