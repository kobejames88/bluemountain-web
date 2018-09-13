package com.bluemountain.modules.expressCompany.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.expressCompany.dao.ExpressCompanyDao;
import com.bluemountain.modules.expressCompany.entity.ExpressCompanyEntity;
import com.bluemountain.modules.expressCompany.service.ExpressCompanyService;
import org.springframework.stereotype.Service;

import java.util.Map;


@Service("expressCompanyService")
public class ExpressCompanyServiceImpl extends ServiceImpl<ExpressCompanyDao, ExpressCompanyEntity> implements ExpressCompanyService {

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<ExpressCompanyEntity> page = this.selectPage(
                new Query<ExpressCompanyEntity>(params).getPage(),
                new EntityWrapper<ExpressCompanyEntity>()
        );

        return new PageUtils(page);
    }

}
