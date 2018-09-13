package com.bluemountain.modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.good.entity.CategoryGoodEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-01 16:28:07
 */
@TableName("cn_category_good")
@ApiModel(value = "CategoryGood")
public class CategoryGoodView  extends CategoryGoodEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CategoryGoodView(){
	}
 
 	public CategoryGoodView(CategoryGoodEntity categoryGoodEntity){
 	try {
			BeanUtils.copyProperties(this, categoryGoodEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
