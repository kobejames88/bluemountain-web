package com.bluemountain.modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.good.entity.GoodImageEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 商品图片表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-24 11:54:40
 */
@TableName("cn_good_image")
@ApiModel(value = "GoodImage")
public class GoodImageView  extends GoodImageEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodImageView(){
	}
 
 	public GoodImageView(GoodImageEntity goodImageEntity){
 	try {
			BeanUtils.copyProperties(this, goodImageEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
