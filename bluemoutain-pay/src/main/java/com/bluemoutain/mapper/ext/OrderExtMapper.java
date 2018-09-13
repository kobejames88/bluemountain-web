package com.bluemoutain.mapper.ext;


import com.bluemoutain.po.ext.SystemOrderExt;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderExtMapper {

    List<SystemOrderExt> findOrderWithUser(@Param("uid") Integer uid,
                                           @Param("status") Integer status,
                                           @Param("outorderid") String oid,
                                           @Param("paytype") Integer ptype,
                                           @Param("otype") Integer otype,
                                           @Param("id") Integer id);


}
