package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.SystemNoticeMapper;
import com.bluemoutain.po.SystemNotice;
import com.bluemoutain.po.SystemNoticeExample;
import com.bluemoutain.service.NoticeService;
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
public class NoticeServiceImpl implements NoticeService {

    @Autowired
    private SystemNoticeMapper mapper;

    @Override
    public int saveNotice(SystemNotice notice) {
        notice.setCreateTime(new Date());
        notice.setStatus(2);
        mapper.insert(notice);
        return notice.getId();
    }

    @Override
    public SystemNotice findById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateNotice(SystemNotice notice) {
        SystemNotice model = mapper.selectByPrimaryKey(notice.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(notice, model);
            model.setCreateTime(new Date());
            return mapper.updateByPrimaryKeyWithBLOBs(model);
        }
        return 0;
    }

    @Override
    public void deleteNotice(Integer id) {
        mapper.deleteByPrimaryKey(id);
    }

    @Override
    public PageBean<SystemNotice> findNoticeByPage(Integer page, Integer rows, Integer status) {
        PageBean<SystemNotice> bean;
        PageHelper.startPage(page, rows);
        SystemNoticeExample example = new SystemNoticeExample();
        SystemNoticeExample.Criteria criteria = example.createCriteria();
        if (status != null) {
            criteria.andStatusEqualTo(status);
        }
        example.setOrderByClause("create_time desc");
        List<SystemNotice> list = mapper.selectByExampleWithBLOBs(example);
        PageInfo<SystemNotice> info = new PageInfo<>(list);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(list);
        return bean;
    }

    @Override
    public List<SystemNotice> findDisplayNotices() {
        SystemNoticeExample example = new SystemNoticeExample();
        SystemNoticeExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(1);
        example.setOrderByClause("orderby");
        return mapper.selectByExampleWithBLOBs(example);
    }


}
