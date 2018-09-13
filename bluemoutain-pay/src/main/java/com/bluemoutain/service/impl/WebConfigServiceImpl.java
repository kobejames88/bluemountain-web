package com.bluemoutain.service.impl;


import com.bluemoutain.mapper.SystemWebMapper;
import com.bluemoutain.po.SystemWebWithBLOBs;
import com.bluemoutain.service.WebConfigService;
import com.bluemoutain.utils.BeanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(rollbackFor = Exception.class)
public class WebConfigServiceImpl implements WebConfigService {

    @Autowired
    private SystemWebMapper webMapper;

    @Override
    public SystemWebWithBLOBs find_by_id(Integer id) {
        return webMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update_web_config(SystemWebWithBLOBs webconfig) {
        SystemWebWithBLOBs web = webMapper.selectByPrimaryKey(webconfig.getId());
        if (web != null) {
            BeanCheck.copyPropertiesIgnoreNull(webconfig, web);
            webMapper.updateByPrimaryKeyWithBLOBs(web);
        }
    }


}
