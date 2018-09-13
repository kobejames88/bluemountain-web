package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.GoodSpecValueDao;
import com.bluemountain.modules.good.entity.GoodSpecValueEntity;
import com.bluemountain.modules.good.service.GoodSpecValueService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("goodSpecValueService")
public class GoodSpecValueServiceImpl extends ServiceImpl<GoodSpecValueDao, GoodSpecValueEntity> implements GoodSpecValueService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<GoodSpecValueEntity> page = this.selectPage(
                new Query<GoodSpecValueEntity>(params).getPage(),
                new EntityWrapper<GoodSpecValueEntity>()
        );

        return new PageUtils(page);
    }

}
