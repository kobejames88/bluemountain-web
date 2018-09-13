package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.SysExtensionMapper;
import com.bluemoutain.po.SysExtension;
import com.bluemoutain.po.SysExtensionExample;
import com.bluemoutain.service.ExtensionService;
import com.bluemoutain.utils.BeanCheck;
import com.bluemoutain.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 返利 业务层
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class ExtensionServiceImpl implements ExtensionService {

    @Autowired
    private SysExtensionMapper sysExtensionMapper;

    @Override
    public BigDecimal cout_exten_by_uid(Integer status, Integer uid) {
        BigDecimal ret = new BigDecimal(0.00);
        SysExtensionExample example = new SysExtensionExample();
        SysExtensionExample.Criteria criteria = example.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andEIdEqualTo(uid);
        List<SysExtension> list = sysExtensionMapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            for (SysExtension sysExtension : list) {
                ret = ret.add(sysExtension.getMoney());
            }
        }
        return ret.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    @Override
    public Integer count_exten_by_uid(Integer status, Integer uid) {
        SysExtensionExample example = new SysExtensionExample();
        SysExtensionExample.Criteria criteria = example.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        criteria.andEIdEqualTo(uid);
        Long count = sysExtensionMapper.countByExample(example);
        return count.intValue();
    }

    @Override
    public void save_exten(SysExtension extension) {
        extension.setCreateTime(new Date());
        sysExtensionMapper.insert(extension);
    }

    @Override
    public PageBean<SysExtension> find_by_page(Integer page, Integer rows, Integer e_uid, Integer r_id, Integer id, Integer status) {
        PageBean<SysExtension> bean;
        PageHelper.startPage(page, rows);
        SysExtensionExample example = new SysExtensionExample();
        SysExtensionExample.Criteria criteria = example.createCriteria();
        if (e_uid != null) {
            criteria.andEIdEqualTo(e_uid);
        }
        if (r_id != null) {
            criteria.andRIdEqualTo(r_id);
        }
        if (id != null) {
            criteria.andIdEqualTo(id);
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        example.setOrderByClause(" create_time desc ");
        List<SysExtension> list = sysExtensionMapper.selectByExample(example);
        PageInfo<SysExtension> info = new PageInfo<>(list);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(list);
        return bean;
    }

    @Override
    public void delete(Integer id) {
        sysExtensionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public SysExtension find_by_id(Integer id) {
        return sysExtensionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(SysExtension extension) {
        SysExtension model = sysExtensionMapper.selectByPrimaryKey(extension.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(extension, model);
            sysExtensionMapper.updateByPrimaryKey(model);
        }
    }



}
