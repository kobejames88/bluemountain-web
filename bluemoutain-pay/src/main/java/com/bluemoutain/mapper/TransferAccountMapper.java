package com.bluemoutain.mapper;


import com.bluemoutain.po.TransferAccount;
import com.bluemoutain.po.TransferAccountExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TransferAccountMapper {
    long countByExample(TransferAccountExample example);

    int deleteByExample(TransferAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TransferAccount record);

    int insertSelective(TransferAccount record);

    List<TransferAccount> selectByExample(TransferAccountExample example);

    TransferAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TransferAccount record, @Param("example") TransferAccountExample example);

    int updateByExample(@Param("record") TransferAccount record, @Param("example") TransferAccountExample example);

    int updateByPrimaryKeySelective(TransferAccount record);

    int updateByPrimaryKey(TransferAccount record);
}