package com.bluemoutain.service.impl;


import com.bluemoutain.mapper.SystemConfigMapper;
import com.bluemoutain.po.SystemConfigExample;
import com.bluemoutain.po.SystemConfigWithBLOBs;
import com.bluemoutain.service.UserConfigService;
import com.bluemoutain.utils.BeanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class UserConfigServiceImpl implements UserConfigService {

    @Autowired
    private SystemConfigMapper configMapper;

    @Override
    public SystemConfigWithBLOBs findConfigByUid(Integer uid) {
        SystemConfigExample example = new SystemConfigExample();
        SystemConfigExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        List<SystemConfigWithBLOBs> list = configMapper.selectByExampleWithBLOBs(example);
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public void updateVonfig(SystemConfigWithBLOBs config) {
        SystemConfigWithBLOBs model = configMapper.selectByPrimaryKey(config.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(config, model);
            configMapper.updateByPrimaryKeyWithBLOBs(model);
        }
    }

    @Override
    public SystemConfigWithBLOBs findConfigByid(Integer id) {
        return configMapper.selectByPrimaryKey(id);
    }

    @Override
    public void deleteById(Integer id) {
        configMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void deleteByUid(Integer uid) {
        SystemConfigExample example = new SystemConfigExample();
        SystemConfigExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        configMapper.deleteByExample(example);
    }


}
