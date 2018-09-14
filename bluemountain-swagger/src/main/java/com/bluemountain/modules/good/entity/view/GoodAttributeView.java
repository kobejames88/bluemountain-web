package com.bluemountain.modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.good.entity.GoodAttributeEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 商品属性表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@TableName("cn_good_attribute")
@ApiModel(value = "GoodAttribute")
public class GoodAttributeView  extends GoodAttributeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodAttributeView(){
	}
 
 	public GoodAttributeView(GoodAttributeEntity goodAttributeEntity){
 	try {
			BeanUtils.copyProperties(this, goodAttributeEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
