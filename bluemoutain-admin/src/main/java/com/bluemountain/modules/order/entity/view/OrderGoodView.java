package com.bluemountain.modules.order.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.order.entity.OrderGoodEntity;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;


/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-28 17:20:46
 */
@TableName("cn_order_good")
@ApiModel(value = "OrderGood")
public class OrderGoodView  extends OrderGoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public OrderGoodView(){
	}
 
 	public OrderGoodView(OrderGoodEntity orderGoodEntity){
 	
 		BeanUtils.copyProperties(this, orderGoodEntity);
	}
}
