package com.bluemountain.modules.adverts.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.adverts.entity.AdvertsEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 广告位表
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-07-11 16:44:18
 */
@TableName("cn_adverts")
@ApiModel(value = "Adverts")
public class AdvertsView  extends AdvertsEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public AdvertsView(){
	}
 
 	public AdvertsView(AdvertsEntity advertsEntity){
 	try {
			BeanUtils.copyProperties(this, advertsEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
