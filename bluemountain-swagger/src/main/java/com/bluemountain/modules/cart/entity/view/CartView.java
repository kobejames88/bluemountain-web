package com.bluemountain.modules.cart.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.cart.entity.CartEntity;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;


/**
 * 购物车
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-05-29 09:47:58
 */
@TableName("cn_cart")
@ApiModel(value = "Cart")
public class CartView  extends CartEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CartView(){
	}
 
 	public CartView(CartEntity cartEntity){
 	
 		BeanUtils.copyProperties(this, cartEntity);
	}
}
