package com.bluemountain.modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;;
import com.bluemountain.modules.good.entity.GoodSpecValueEntity;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;


/**
 * 
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-23 12:01:16
 */
@TableName("cn_good_spec_value")
@ApiModel(value = "GoodSpecValue")
public class GoodSpecValueView  extends GoodSpecValueEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public GoodSpecValueView(){
	}
 
 	public GoodSpecValueView(GoodSpecValueEntity goodSpecValueEntity){
 	
 		BeanUtils.copyProperties(this, goodSpecValueEntity);
	}
}
