package com.bluemountain.modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.good.entity.GoodParameterEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 商品参数表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-07 08:56:45
 */
@TableName("cn_good_parameter")
@ApiModel(value = "GoodParameter")
public class GoodParameterView  extends GoodParameterEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodParameterView(){
	}
 
 	public GoodParameterView(GoodParameterEntity goodParameterEntity){
 	try {
			BeanUtils.copyProperties(this, goodParameterEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
