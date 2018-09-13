package com.bluemountain.modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.good.entity.CategoryEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 分类表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
@TableName("cn_category")
@ApiModel(value = "Category")
public class CategoryView  extends CategoryEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public CategoryView(){
	}
 
 	public CategoryView(CategoryEntity categoryEntity){
 	try {
			BeanUtils.copyProperties(this, categoryEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
 	
 	private String categoryParentName;

 	private String channelName;
 	
 	
	public String getChannelName() {
		return channelName;
	}

	public void setChannelName(String channelName) {
		this.channelName = channelName;
	}

	public String getCategoryParentName() {
		return categoryParentName;
	}

	public void setCategoryParentName(String categoryParentName) {
		this.categoryParentName = categoryParentName;
	}
 	
 	
 	
 	
}
