package com.bluemoutain.service.impl;


import com.bluemoutain.mapper.SystemVipMapper;
import com.bluemoutain.po.SystemVip;
import com.bluemoutain.po.SystemVipExample;
import com.bluemoutain.service.VipService;
import com.bluemoutain.utils.BeanCheck;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;


@Service
@Transactional(rollbackFor = RuntimeException.class)
public class VipServiceImpl implements VipService {

    @Autowired
    private SystemVipMapper vipMapper;

    @Override
    public SystemVip find_vip_by_id(Integer id) {
        return vipMapper.selectByPrimaryKey(id);
    }

    @Override
    public SystemVip find_vip_by_uid(Integer uid) {
        SystemVipExample example = new SystemVipExample();
        SystemVipExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        List<SystemVip> vips = vipMapper.selectByExample(example);
        if (vips != null && vips.size() > 0) {
            return vips.get(0);
        }
        return null;
    }

    @Override
    public Integer save_vip_info(SystemVip vip) {
        vip.setCreateTime(new Date());
        vip.setOptTime(new Date());
        vipMapper.insert(vip);
        return vip.getId();
    }

    @Override
    public Integer update_vip_info(SystemVip vip) {
        SystemVip model = vipMapper.selectByPrimaryKey(vip.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(vip, model);
            model.setOptTime(new Date());
            return vipMapper.updateByPrimaryKey(model);
        }
        return null;
    }

}
