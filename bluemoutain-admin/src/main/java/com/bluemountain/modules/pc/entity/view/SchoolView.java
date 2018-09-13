package com.bluemountain.modules.pc.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.pc.entity.SchoolEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
@TableName("t_school")
@ApiModel(value = "School")
public class SchoolView  extends SchoolEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public SchoolView(){
	}
 
 	public SchoolView(SchoolEntity schoolEntity){
 	try {
			BeanUtils.copyProperties(this, schoolEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
