package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.PutForwardConfigMapper;
import com.bluemoutain.mapper.PutForwardMapper;
import com.bluemoutain.po.PutForward;
import com.bluemoutain.po.PutForwardConfig;
import com.bluemoutain.po.PutForwardExample;
import com.bluemoutain.service.PutForwardService;
import com.bluemoutain.utils.BeanCheck;
import com.bluemoutain.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional(rollbackFor = Exception.class)
public class PutForwardServiceImpl implements PutForwardService {

    @Autowired
    private PutForwardMapper mapper;

    @Autowired
    private PutForwardConfigMapper putForwardConfigMapper;

    @Override
    public int savePF(PutForward forward) {
        forward.setOptTime(new Date());
        return mapper.insert(forward);
    }

    @Override
    public PutForward find_by_id(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updatePF(PutForward account) {
        PutForward model = mapper.selectByPrimaryKey(account.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(account, model);
            model.setOptTime(new Date());
            mapper.updateByPrimaryKey(account);
        }
    }

    @Override
    public void deletePF(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBean<PutForward> findByPage(Integer page, Integer rows, Integer status, String name, String sid, Integer type) {
        PageBean<PutForward> bean;
        PageHelper.startPage(page, rows);
        PutForwardExample example = new PutForwardExample();
        PutForwardExample.Criteria criteria = example.createCriteria();
        example.setOrderByClause("opt_time desc");
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        if (name != null && name.length() > 0) {
            criteria.andPutNameLike("%" + name + "%");
        }
        if (sid != null && sid.length() > 2) {
            criteria.andPsdEqualTo(sid);
        }
        if (type != null) {
            criteria.andPTypeEqualTo(type);
        }
        List<PutForward> list = mapper.selectByExample(example);
        PageInfo<PutForward> info = new PageInfo<>(list);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(list);
        return bean;
    }

    @Override
    public PutForwardConfig findConfig(Integer id) {
        return putForwardConfigMapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateConfig(PutForwardConfig config) {
        PutForwardConfig model = putForwardConfigMapper.selectByPrimaryKey(config.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(config, model);
            model.setOptTime(new Date());
            putForwardConfigMapper.updateByPrimaryKey(model);
        }
    }

    @Override
    public List<PutForward> find_by_status(Integer status) {
        PutForwardExample example = new PutForwardExample();
        PutForwardExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return mapper.selectByExample(example);
    }


}
