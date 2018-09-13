package com.bluemoutain.service.impl;

import com.bluemoutain.mapper.SystemOrderMapper;
import com.bluemoutain.mapper.ext.OrderExtMapper;
import com.bluemoutain.po.SystemOrder;
import com.bluemoutain.po.SystemOrderExample;
import com.bluemoutain.po.ext.SystemOrderExt;
import com.bluemoutain.service.OrderService;
import com.bluemoutain.utils.BeanCheck;
import com.bluemoutain.utils.PageBean;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Transactional(rollbackFor = RuntimeException.class)
public class OrderServiceImpl implements OrderService {

    private static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private SystemOrderMapper mapper;

    @Autowired
    private OrderExtMapper orderExtMapper;

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Override
    public int createOrder(SystemOrder order) {
        mapper.insert(order);
        Set<String> keys = redisTemplate.keys("index_page:*");
        redisTemplate.delete(keys);
        return order.getId();
    }

    @Override
    public SystemOrder findOrderById(Integer id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public void updateOrder(SystemOrder order) {
        SystemOrder model = mapper.selectByPrimaryKey(order.getId());
        if (model != null) {
            BeanCheck.copyPropertiesIgnoreNull(order, model);
            mapper.updateByPrimaryKey(order);
        }
    }

    @Override
    public void deleteOrder(Integer orderid) {
        mapper.deleteByPrimaryKey(orderid);
    }

    @Override
    public SystemOrder findOrderByOutOrderId(String id) {
        SystemOrderExample example = new SystemOrderExample();
        SystemOrderExample.Criteria criteria = example.createCriteria();
        criteria.andOutOrderIdEqualTo(id);
        List<SystemOrder> systemOrders = mapper.selectByExample(example);
        if (systemOrders != null && systemOrders.size() > 0) {
            return systemOrders.get(0);
        }
        return null;
    }

    @Override
    public PageBean<SystemOrder> findByPage(Integer page, Integer rows) {
        PageBean<SystemOrder> bean;
        PageHelper.startPage(page, rows);
        SystemOrderExample example = new SystemOrderExample();
        example.setOrderByClause("create_time desc");
        List<SystemOrder> users = mapper.selectByExample(example);
        PageInfo<SystemOrder> info = new PageInfo<>(users);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(users);
        return bean;
    }

    @Override
    public PageBean<SystemOrderExt> findByPage2(Integer page, Integer rows, Integer uid, Integer status, Integer payType, String outOrderId, Integer order_type, Integer oid) {
        PageBean<SystemOrderExt> bean;
        PageHelper.startPage(page, rows);
        if (outOrderId != null && outOrderId.length() == 0) {
            outOrderId = null;
        }
        List<SystemOrderExt> users = orderExtMapper.findOrderWithUser(uid, status, outOrderId, payType, order_type, oid);
        PageInfo<SystemOrderExt> info = new PageInfo<>(users);
        bean = new PageBean<>(page, rows, (int) info.getTotal());
        bean.setItems(users);
        return bean;
    }

    @Override
    public List<SystemOrder> findOrderByStatus(Integer status) {
        SystemOrderExample example = new SystemOrderExample();
        SystemOrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        return mapper.selectByExample(example);
    }

    @Override
    public List<SystemOrder> findOrderByStatus(Integer status, Integer sett) {
        SystemOrderExample example = new SystemOrderExample();
        SystemOrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        criteria.andIsSettEqualTo(sett);
        return mapper.selectByExample(example);
    }

    @Override
    public Integer countOrderPayType(Integer payType, Date timelike) {
        SystemOrderExample example = new SystemOrderExample();
        SystemOrderExample.Criteria criteria = example.createCriteria();
        if (timelike != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(timelike);
            calendar.add(Calendar.DATE, 1);
            Date tmp = calendar.getTime();
            criteria.andCreateTimeBetween(timelike, tmp);
        }
        if (payType != null) {
            criteria.andPayTypeEqualTo(payType);
        }
        List<SystemOrder> orders = mapper.selectByExample(example);
        if (orders != null) {
            return orders.size();
        }
        return 0;
    }

    @Override
    public List<SystemOrder> findOrderList2(Integer status, Integer is_notify, Integer order_type) {
        SystemOrderExample example = new SystemOrderExample();
        SystemOrderExample.Criteria criteria = example.createCriteria();
        criteria.andStatusEqualTo(status);
        criteria.andIsNotifyEqualTo(is_notify);
        criteria.andOrderTypeEqualTo(order_type);
        return mapper.selectByExample(example);
    }


}
