package com.bluemountain.modules.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.sys.dao.AddressDao;
import com.bluemountain.modules.sys.entity.AddressEntity;
import com.bluemountain.modules.sys.service.AddressService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("addressService")
public class AddressServiceImpl extends ServiceImpl<AddressDao, AddressEntity> implements AddressService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<AddressEntity> page = this.selectPage(
                new Query<AddressEntity>(params).getPage(),
                new EntityWrapper<AddressEntity>()
        );

        return new PageUtils(page);
    }

}
