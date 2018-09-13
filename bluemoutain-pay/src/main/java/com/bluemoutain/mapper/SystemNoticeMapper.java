package com.bluemoutain.mapper;

import com.bluemoutain.po.SystemNotice;
import com.bluemoutain.po.SystemNoticeExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemNoticeMapper {
    long countByExample(SystemNoticeExample example);

    int deleteByExample(SystemNoticeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemNotice record);

    int insertSelective(SystemNotice record);

    List<SystemNotice> selectByExampleWithBLOBs(SystemNoticeExample example);

    List<SystemNotice> selectByExample(SystemNoticeExample example);

    SystemNotice selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemNotice record, @Param("example") SystemNoticeExample example);

    int updateByExampleWithBLOBs(@Param("record") SystemNotice record, @Param("example") SystemNoticeExample example);

    int updateByExample(@Param("record") SystemNotice record, @Param("example") SystemNoticeExample example);

    int updateByPrimaryKeySelective(SystemNotice record);

    int updateByPrimaryKeyWithBLOBs(SystemNotice record);

    int updateByPrimaryKey(SystemNotice record);
}