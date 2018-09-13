package com.bluemountain.service;


import com.bluemountain.dto.Exposer;
import com.bluemountain.dto.SeckillExecution;
import com.bluemountain.entity.Seckill;
import com.bluemountain.exception.RepeatKillException;
import com.bluemountain.exception.SeckillCloseException;
import com.bluemountain.exception.SeckillException;

import java.util.List;

/**
 * Created by GZR on 2016/11/23.
 */
public interface SeckillService {
    /**
     * select all goods
     * @return
     */
    List<Seckill> getSeckillList();

    /**
     *
     * @return
     */
    Seckill querySeckillById(long seckillId);
    /**
     * get seckill url
     * @param seckillId
     * @return
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * execute seckill by procedure
     * @param seckillId
     * @param userPhone
     * @param md5
     * @return
     * @throws RepeatKillException
     * @throws SeckillCloseException
     * @throws SeckillException
     */
    SeckillExecution executeSeckillProcedure(long seckillId, long userPhone, String md5)throws RepeatKillException,SeckillCloseException,SeckillException;


    public SeckillExecution executeSeckill(long seckillId, long userPhone, String md5) throws RepeatKillException, SeckillCloseException, SeckillException;
}
