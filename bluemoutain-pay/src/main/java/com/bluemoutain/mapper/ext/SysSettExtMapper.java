package com.bluemoutain.mapper.ext;


import com.bluemoutain.po.ext.SysSettExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysSettExtMapper {

    List<SysSettExt> findpage(@Param("sid") String sid,
                              @Param("status") Integer status,
                              @Param("type") Integer type,
                              @Param("uid") Integer uid);

}
