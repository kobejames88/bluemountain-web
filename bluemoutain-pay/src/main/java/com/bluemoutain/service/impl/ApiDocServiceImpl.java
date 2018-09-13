package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.SystemDocMapper;
import com.bluemoutain.po.SystemDoc;
import com.bluemoutain.po.SystemDocExample;
import com.bluemoutain.service.ApiDocService;
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
public class ApiDocServiceImpl implements ApiDocService {

    @Autowired
    private SystemDocMapper mapper;

    @Override
    public void saveDocs(SystemDoc doc) {
        doc.setCreateTime(new Date());
        mapper.insert(doc);
    }

    @Override
    public SystemDoc findDocById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateDocById(SystemDoc doc) {
        SystemDoc model = mapper.selectByPrimaryKey(doc.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(doc, model);
            mapper.updateByPrimaryKeyWithBLOBs(model);
        }
    }

    @Override
    public void deleteDocById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBean<SystemDoc> findDocByPage(Integer page, Integer rows, Integer status) {
        PageBean<SystemDoc> bean;
        PageHelper.startPage(page, rows);
        SystemDocExample example = new SystemDocExample();
        SystemDocExample.Criteria criteria = example.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        example.setOrderByClause("order_by");
        List<SystemDoc> list = mapper.selectByExampleWithBLOBs(example);
        PageInfo<SystemDoc> info = new PageInfo<>(list);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(list);
        return bean;
    }

    @Override
    public List<SystemDoc> findAllDisplayDoc(Integer status) {
        SystemDocExample example = new SystemDocExample();
        SystemDocExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        example.setOrderByClause("order_by");
        return mapper.selectByExampleWithBLOBs(example);
    }
}
