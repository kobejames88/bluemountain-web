package com.bluemountain.modules.order.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bluemountain.modules.order.entity.OrderEntity;
import com.bluemountain.modules.order.entity.view.OrderView;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 订单主表
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 15:57:37
 */
public interface OrderDao extends BaseMapper<OrderEntity> {
	List<OrderView> selectListView(@Param("ew") Wrapper<OrderEntity> wrapper);

	List<OrderView> selectListView(Pagination page, @Param("ew") Wrapper<OrderEntity> wrapper);
	
	OrderView selectView(@Param("ew") Wrapper<OrderEntity> wrapper);
}
