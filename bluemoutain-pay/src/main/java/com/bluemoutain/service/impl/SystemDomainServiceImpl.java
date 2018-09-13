package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.SystemDomainMapper;
import com.bluemoutain.mapper.ext.DomainCheckExtMapper;
import com.bluemoutain.po.SystemDomain;
import com.bluemoutain.po.SystemDomainExample;
import com.bluemoutain.po.ext.DomainCheckExtQuery;
import com.bluemoutain.service.SystemDomainService;
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
public class SystemDomainServiceImpl implements SystemDomainService {

    @Autowired
    private SystemDomainMapper mapper;

    @Autowired
    private DomainCheckExtMapper extMapper;

    @Override
    public SystemDomain findByDomain(String domain) {
        SystemDomainExample example = new SystemDomainExample();
        SystemDomainExample.Criteria criteria = example.createCriteria();
        criteria.andSerachEqualTo(domain);
        List<SystemDomain> domains = mapper.selectByExample(example);
        if (domains != null && domains.size() > 0) {
            return domains.get(0);
        }
        return null;
    }

    @Override
    public int saveDomain(SystemDomain domain) {
        domain.setOptTime(new Date());
        return mapper.insert(domain);
    }

    @Override
    public void deleteById(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public SystemDomain find_by_id(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateDomain(SystemDomain domain) {
        SystemDomain model = mapper.selectByPrimaryKey(domain.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(domain, model);
            model.setOptTime(new Date());
            mapper.updateByPrimaryKey(model);
        }
    }

    @Override
    public PageBean<SystemDomain> findDomainByPage(Integer page, Integer rows, String domain) {
        PageBean<SystemDomain> bean;
        PageHelper.startPage(page, rows);
        SystemDomainExample example = new SystemDomainExample();
        SystemDomainExample.Criteria criteria = example.createCriteria();
        if (domain != null && domain.length() > 3) {
            criteria.andDomainLike("%" + domain + "%");
        }
        List<SystemDomain> domains = mapper.selectByExample(example);
        PageInfo<SystemDomain> info = new PageInfo<>(domains);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(domains);
        return bean;
    }

    @Override
    public PageBean<SystemDomain> findDomainByPage2(Integer page, Integer rows, String domain, Integer status, Integer nature, String serach) {
        PageBean<SystemDomain> bean;
        PageHelper.startPage(page, rows);
        SystemDomainExample example = new SystemDomainExample();
        SystemDomainExample.Criteria criteria = example.createCriteria();
        if (domain != null && domain.length() > 3) {
            criteria.andDomainLike("%" + domain + "%");
        }
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        if (nature != null) {
            if (nature == 1) {
                criteria.andNatureLike("%个人%");
            } else {
                criteria.andNatureLike("%企业%");
            }
        }
        if (serach != null && serach.length() > 0) {
            criteria.andSerachLike("%" + serach + "%");
        }
        List<SystemDomain> domains = mapper.selectByExample(example);
        PageInfo<SystemDomain> info = new PageInfo<>(domains);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(domains);
        return bean;
    }

    @Override
    public List<SystemDomain> find_all() {
        SystemDomainExample example = new SystemDomainExample();
        return mapper.selectByExample(example);
    }

    @Override
    public PageBean<DomainCheckExtQuery> findDomainByPage(Integer page, Integer rows, Integer pay_status, Integer pay_show_info, Integer pid, String serach) {
        PageBean<DomainCheckExtQuery> bean;
        if (serach != null && serach.trim().length() == 0) {
            serach = null;
        }
        PageHelper.startPage(page, rows);
        List<DomainCheckExtQuery> list = extMapper.findList(pay_status, pay_show_info, pid, serach);
        PageInfo<DomainCheckExtQuery> info = new PageInfo<>(list);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(list);
        return bean;
    }


}
