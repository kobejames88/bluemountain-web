package com.bluemoutain.mapper;


import com.bluemoutain.po.PutForward;
import com.bluemoutain.po.PutForwardExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PutForwardMapper {
    long countByExample(PutForwardExample example);

    int deleteByExample(PutForwardExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PutForward record);

    int insertSelective(PutForward record);

    List<PutForward> selectByExample(PutForwardExample example);

    PutForward selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PutForward record, @Param("example") PutForwardExample example);

    int updateByExample(@Param("record") PutForward record, @Param("example") PutForwardExample example);

    int updateByPrimaryKeySelective(PutForward record);

    int updateByPrimaryKey(PutForward record);
}