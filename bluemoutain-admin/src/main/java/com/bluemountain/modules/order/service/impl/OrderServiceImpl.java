package com.bluemountain.modules.order.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.bluemountain.common.utils.MPUtil;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.Query;
import com.bluemountain.modules.order.dao.OrderDao;
import com.bluemountain.modules.order.entity.OrderEntity;
import com.bluemountain.modules.order.entity.view.OrderView;
import com.bluemountain.modules.order.service.OrderService;
import com.bluemountain.modules.user.entity.UserEntity;
import com.bluemountain.modules.user.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service("orderService")
public class OrderServiceImpl extends ServiceImpl<OrderDao, OrderEntity> implements OrderService {
    @Autowired
    UserService userService;

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        String selectType=(String)params.get("selectType");
        String selectValue=(String)params.get("selectValue");
        String orderStatus=(String)params.get("orderStatus");
        EntityWrapper<OrderEntity> orderEntityWrapper=new EntityWrapper<OrderEntity>();
       
            if("userName".equals(selectType)){
                EntityWrapper<UserEntity> userEntityWrapper=new EntityWrapper<UserEntity>();
                List<Object> userIdsList=userService.selectObjs(userEntityWrapper.like("user_name",selectValue));
              orderEntityWrapper.in("user.user_id",userIdsList);
            }else {
            	orderEntityWrapper.like(MPUtil.camelToUnderline(selectType), selectValue);
            }
            orderEntityWrapper.eq(StringUtils.isNotBlank(orderStatus), "order_status", orderStatus);
            Page<OrderView> page =new Query<OrderView>(params).getPage();
            page.setRecords(baseMapper.selectListView(page,orderEntityWrapper));
        	PageUtils pageUtil = new PageUtils(page);
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<OrderEntity> wrapper) {
		Page<OrderView> page =new Query<OrderView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,wrapper));
    	PageUtils pageUtil = new PageUtils(page);
    	return pageUtil;
	}

}
