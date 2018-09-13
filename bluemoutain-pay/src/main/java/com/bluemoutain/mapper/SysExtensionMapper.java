package com.bluemoutain.mapper;


import com.bluemoutain.po.SysExtension;
import com.bluemoutain.po.SysExtensionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SysExtensionMapper {
    long countByExample(SysExtensionExample example);

    int deleteByExample(SysExtensionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SysExtension record);

    int insertSelective(SysExtension record);

    List<SysExtension> selectByExample(SysExtensionExample example);

    SysExtension selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SysExtension record, @Param("example") SysExtensionExample example);

    int updateByExample(@Param("record") SysExtension record, @Param("example") SysExtensionExample example);

    int updateByPrimaryKeySelective(SysExtension record);

    int updateByPrimaryKey(SysExtension record);
}