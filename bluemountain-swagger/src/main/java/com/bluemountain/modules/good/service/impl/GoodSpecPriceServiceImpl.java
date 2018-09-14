package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.GoodSpecPriceDao;
import com.bluemountain.modules.good.entity.GoodSpecPriceEntity;
import com.bluemountain.modules.good.service.GoodSpecPriceService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("goodSpecPriceService")
public class GoodSpecPriceServiceImpl extends ServiceImpl<GoodSpecPriceDao, GoodSpecPriceEntity> implements GoodSpecPriceService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodSpecPriceEntity> page = this.selectPage(
                new Query<GoodSpecPriceEntity>(params).getPage(),
                new EntityWrapper<GoodSpecPriceEntity>()
        );

        return new PageUtils(page);
    }

}
