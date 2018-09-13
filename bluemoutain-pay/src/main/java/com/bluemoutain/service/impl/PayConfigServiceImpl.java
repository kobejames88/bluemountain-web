package com.bluemoutain.service.impl;


import com.bluemoutain.mapper.SystemPayConfigMapper;
import com.bluemoutain.po.SystemPayConfigWithBLOBs;
import com.bluemoutain.service.PayConfigService;
import com.bluemoutain.utils.BeanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class PayConfigServiceImpl implements PayConfigService {

    @Autowired
    private SystemPayConfigMapper payConfigMapper;

    @Override
    public SystemPayConfigWithBLOBs getPayConfig(Integer id) {
        return payConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updatePPayConfig(SystemPayConfigWithBLOBs payConfig) {
        SystemPayConfigWithBLOBs config = payConfigMapper.selectByPrimaryKey(payConfig.getId());
        if (config != null) {
            BeanCheck.copyPropertiesIgnoreNull(payConfig, config);
            payConfigMapper.updateByPrimaryKeyWithBLOBs(config);
        }
    }

}
