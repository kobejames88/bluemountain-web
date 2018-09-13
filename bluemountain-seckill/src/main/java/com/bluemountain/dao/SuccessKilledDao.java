package com.bluemountain.dao;

import com.bluemountain.entity.SuccessKilled;
import org.apache.ibatis.annotations.Param;


/**
 * Created by GZR on 2016/11/23.
 */
public interface SuccessKilledDao {

    /**
     *
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessKilled(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * get SuccessKilled and Seckill goods
     * @param seckillId
     * @param userPhone
     * @return
     */
    SuccessKilled queryByIdWithSeckill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

}
