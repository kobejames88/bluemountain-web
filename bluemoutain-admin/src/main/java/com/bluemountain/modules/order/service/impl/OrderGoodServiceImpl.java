package com.bluemountain.modules.order.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.order.dao.OrderGoodDao;
import com.bluemountain.modules.order.entity.OrderGoodEntity;
import com.bluemountain.modules.order.service.OrderGoodService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("orderGoodService")
public class OrderGoodServiceImpl extends ServiceImpl<OrderGoodDao, OrderGoodEntity> implements OrderGoodService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<OrderGoodEntity> page = this.selectPage(
                new Query<OrderGoodEntity>(params).getPage(),
                new EntityWrapper<OrderGoodEntity>()
        );

        return new PageUtils(page);
    }

}
