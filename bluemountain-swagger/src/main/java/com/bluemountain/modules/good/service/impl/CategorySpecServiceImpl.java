package com.bluemountain.modules.good.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.good.dao.CategorySpecDao;
import com.bluemountain.modules.good.entity.CategorySpecEntity;
import com.bluemountain.modules.good.service.CategorySpecService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("goodSpecService")
public class CategorySpecServiceImpl extends ServiceImpl<CategorySpecDao, CategorySpecEntity> implements CategorySpecService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<CategorySpecEntity> page = this.selectPage(
                new Query<CategorySpecEntity>(params).getPage(),
                new EntityWrapper<CategorySpecEntity>()
        );

        return new PageUtils(page);
    }

}
