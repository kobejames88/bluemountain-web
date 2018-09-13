package com.bluemoutain.mapper;


import com.bluemoutain.po.PutForwardConfig;
import com.bluemoutain.po.PutForwardConfigExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PutForwardConfigMapper {
    long countByExample(PutForwardConfigExample example);

    int deleteByExample(PutForwardConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PutForwardConfig record);

    int insertSelective(PutForwardConfig record);

    List<PutForwardConfig> selectByExample(PutForwardConfigExample example);

    PutForwardConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PutForwardConfig record, @Param("example") PutForwardConfigExample example);

    int updateByExample(@Param("record") PutForwardConfig record, @Param("example") PutForwardConfigExample example);

    int updateByPrimaryKeySelective(PutForwardConfig record);

    int updateByPrimaryKey(PutForwardConfig record);
}