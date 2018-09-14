package com.bluemountain.modules.cart.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.cart.dao.CartDao;
import com.bluemountain.modules.cart.entity.CartEntity;
import com.bluemountain.modules.cart.service.CartService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("cartService")
public class CartServiceImpl extends ServiceImpl<CartDao, CartEntity> implements CartService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CartEntity> page = this.selectPage(
                new Query<CartEntity>(params).getPage(),
                new EntityWrapper<CartEntity>()
        );

        return new PageUtils(page);
    }

}
