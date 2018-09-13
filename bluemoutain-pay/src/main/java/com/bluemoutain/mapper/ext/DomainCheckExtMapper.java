package com.bluemoutain.mapper.ext;


import com.bluemoutain.po.ext.DomainCheckExtQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DomainCheckExtMapper {

    List<DomainCheckExtQuery> findList(@Param("pay_status") Integer pay_status,
                                       @Param("pay_show_info") Integer pay_show_info,
                                       @Param("pid") Integer pid,
                                       @Param("serach") String serach);


}
