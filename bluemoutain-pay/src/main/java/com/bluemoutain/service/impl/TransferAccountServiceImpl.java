package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.TransferAccountMapper;
import com.bluemoutain.po.TransferAccount;
import com.bluemoutain.po.TransferAccountExample;
import com.bluemoutain.service.TransferAccountService;
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
public class TransferAccountServiceImpl implements TransferAccountService {

    @Autowired
    private TransferAccountMapper mapper;

    @Override
    public int saveTF(TransferAccount account) {
        account.setOptTime(new Date());
        return mapper.insert(account);
    }

    @Override
    public TransferAccount find_by_id(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateTF(TransferAccount account) {
        TransferAccount model = mapper.selectByPrimaryKey(account.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(account, model);
            model.setOptTime(new Date());
            mapper.updateByPrimaryKey(model);
        }
    }

    @Override
    public void deleteTF(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBean<TransferAccount> findByPage(Integer page, Integer rows, Integer status, String name, String sid, Integer type) {
        PageBean<TransferAccount> bean;
        PageHelper.startPage(page, rows);
        TransferAccountExample example = new TransferAccountExample();
        example.setOrderByClause("opt_time desc");
        TransferAccountExample.Criteria criteria = example.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        if (name != null && name.length() > 0) {
            criteria.andPutNameLike("%" + name + "%");
        }
        if (sid != null && sid.length() > 10) {
            criteria.andPsdEqualTo(sid);
        }
        if (type != null) {
            criteria.andPTypeEqualTo(type);
        }
        List<TransferAccount> list = mapper.selectByExample(example);
        PageInfo<TransferAccount> info = new PageInfo<>(list);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(list);
        return bean;
    }


}
