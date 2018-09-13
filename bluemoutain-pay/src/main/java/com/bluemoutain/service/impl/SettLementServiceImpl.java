package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.SystemSettMapper;
import com.bluemoutain.mapper.ext.SysSettExtMapper;
import com.bluemoutain.mapper.ext.SystemCountMapper;
import com.bluemoutain.po.SystemSett;
import com.bluemoutain.po.SystemSettExample;
import com.bluemoutain.po.ext.SysSettExt;
import com.bluemoutain.service.SettLementService;
import com.bluemoutain.utils.BeanCheck;
import com.bluemoutain.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.*;

@Service
@Transactional(rollbackFor = Exception.class)
public class SettLementServiceImpl implements SettLementService {

    @Autowired
    private SystemSettMapper mapper;

    @Autowired
    private SysSettExtMapper sysSettExtMapper;

    @Autowired
    private SystemCountMapper countMapper;

    @Override
    public int saveSettLement(SystemSett sett) {
        mapper.insert(sett);
        return sett.getId();
    }

    @Override
    public PageBean<SysSettExt> findByPage(Integer page, Integer rows, Integer status, String sid, Integer type, Integer uid) {
        PageBean<SysSettExt> bean;
        PageHelper.startPage(page, rows);
        if (sid != null && sid.length() == 0) {
            sid = null;
        }
        List<SysSettExt> list = sysSettExtMapper.findpage(sid, status, type, uid);
        PageInfo<SysSettExt> info = new PageInfo<>(list);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(list);
        return bean;
    }

    @Override
    public SystemSett find_sett_byId(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public SystemSett find_sett_by_uid(Integer uid) {
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        List<SystemSett> setts = mapper.selectByExample(example);
        if (setts != null && setts.size() > 0) {
            return setts.get(0);
        }
        return null;
    }

    @Override
    public void updateSystemSett(SystemSett sett) {
        SystemSett model = mapper.selectByPrimaryKey(sett.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(sett, model);
            mapper.updateByPrimaryKey(model);
        }
    }

    @Override
    public void deleteSystemSett(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public List<SystemSett> findsettByUid(Integer uid) {
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        example.setOrderByClause("create_time desc");
        return mapper.selectByExample(example);
    }

    @Override
    public List<SystemSett> findAllSett(Integer status) {
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return mapper.selectByExample(example);
    }

    @Override
    public List<SystemSett> findAllSett2(Integer sett) {
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        criteria.andIsSettEqualTo(sett);
        return mapper.selectByExample(example);
    }

    @Override
    public Integer settCountAll(Integer uid, Date timelike) {
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        if (uid != null) {
            criteria.andUidEqualTo(uid);
        }
        if (timelike != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(timelike);
            calendar.add(Calendar.DATE, 1);
            Date tmp = calendar.getTime();
            criteria.andCreateTimeBetween(timelike, tmp);
        }
        List<SystemSett> setts = mapper.selectByExample(example);
        if (setts != null) {
            return setts.size();
        }
        return 0;
    }

    @Override
    public Integer settPayOkCount(Integer uid, Date timelike) {
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        if (uid != null) {
            criteria.andUidEqualTo(uid);
        }
        criteria.andStatusEqualTo(2);
        if (timelike != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(timelike);
            calendar.add(Calendar.DATE, 1);
            Date tmp = calendar.getTime();
            criteria.andCreateTimeBetween(timelike, tmp);
        }
        List<SystemSett> setts = mapper.selectByExample(example);
        if (setts != null) {
            return setts.size();
        }
        return 0;
    }

    @Override
    public Integer settPayFaildCount(Integer uid, Date timelike) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(3);
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        if (uid != null) {
            criteria.andUidEqualTo(uid);
        }
        criteria.andStatusIn(list);
        if (timelike != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(timelike);
            calendar.add(Calendar.DATE, 1);
            Date tmp = calendar.getTime();
            criteria.andCreateTimeBetween(timelike, tmp);
        }
        List<SystemSett> setts = mapper.selectByExample(example);
        if (setts != null) {
            return setts.size();
        }
        return 0;
    }

    @Override
    public Integer settCanelCount(Integer uid, Date timelike) {
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        if (uid != null) {
            criteria.andUidEqualTo(uid);
        }
        criteria.andStatusEqualTo(4);
        if (timelike != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(timelike);
            calendar.add(Calendar.DATE, 1);
            Date tmp = calendar.getTime();
            criteria.andCreateTimeBetween(timelike, tmp);
        }
        List<SystemSett> setts = mapper.selectByExample(example);
        if (setts != null) {
            return setts.size();
        }
        return 0;
    }

    @Override
    public BigDecimal settPayMoney(Integer uid, Integer status, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return countMapper.settPayMoney(uid, status, timelike);
    }

    @Override
    public BigDecimal settPaySubMoney(Integer uid, Integer status, String timelike) {
        if (timelike == null) {
            timelike = "%%";
        } else {
            timelike = "%" + timelike + "%";
        }
        return countMapper.settPaySubMoney(uid, status, timelike);
    }

    @Override
    public BigDecimal findUserSettPayCount(Integer uid) {
        BigDecimal ret = new BigDecimal("0.00");
        SystemSettExample example = new SystemSettExample();
        SystemSettExample.Criteria criteria = example.createCriteria();
        criteria.andUidEqualTo(uid);
        ArrayList<Integer> select = new ArrayList<>();
        select.add(1);
        select.add(2);
        select.add(3);
        criteria.andStatusIn(select);
        List<SystemSett> list = mapper.selectByExample(example);
        if (list != null && list.size() > 0) {
            for (SystemSett systemSett : list) {
                ret = ret.add(systemSett.getSettFinalMoney());
            }
        }
        return ret;
    }


}
