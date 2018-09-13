package com.bluemoutain.mapper;


import com.bluemoutain.po.SystemVip;
import com.bluemoutain.po.SystemVipExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemVipMapper {
    long countByExample(SystemVipExample example);

    int deleteByExample(SystemVipExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemVip record);

    int insertSelective(SystemVip record);

    List<SystemVip> selectByExample(SystemVipExample example);

    SystemVip selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemVip record, @Param("example") SystemVipExample example);

    int updateByExample(@Param("record") SystemVip record, @Param("example") SystemVipExample example);

    int updateByPrimaryKeySelective(SystemVip record);

    int updateByPrimaryKey(SystemVip record);
}