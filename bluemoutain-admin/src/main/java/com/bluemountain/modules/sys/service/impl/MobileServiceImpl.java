package com.bluemountain.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.sys.dao.MobileDao;
import com.bluemountain.modules.sys.entity.MobileEntity;
import com.bluemountain.modules.sys.service.MobileService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("mobileService")
public class MobileServiceImpl extends ServiceImpl<MobileDao, MobileEntity> implements MobileService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<MobileEntity> page = this.selectPage(
                new Query<MobileEntity>(params).getPage(),
                new EntityWrapper<MobileEntity>()
        );

        return new PageUtils(page);
    }

}
