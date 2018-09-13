package com.bluemoutain.mapper;


import com.bluemoutain.po.SystemDomain;
import com.bluemoutain.po.SystemDomainExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SystemDomainMapper {
    long countByExample(SystemDomainExample example);

    int deleteByExample(SystemDomainExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SystemDomain record);

    int insertSelective(SystemDomain record);

    List<SystemDomain> selectByExample(SystemDomainExample example);

    SystemDomain selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SystemDomain record, @Param("example") SystemDomainExample example);

    int updateByExample(@Param("record") SystemDomain record, @Param("example") SystemDomainExample example);

    int updateByPrimaryKeySelective(SystemDomain record);

    int updateByPrimaryKey(SystemDomain record);
}