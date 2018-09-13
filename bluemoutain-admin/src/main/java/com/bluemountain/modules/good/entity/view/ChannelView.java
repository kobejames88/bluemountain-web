package com.bluemountain.modules.good.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.good.entity.ChannelEntity;
import io.swagger.annotations.ApiModel;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 频道
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-05-28 17:34:00
 */
@TableName("cn_channel")
@ApiModel(value = "Channel")
public class ChannelView  extends ChannelEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ChannelView(){
	}
 
 	public ChannelView(ChannelEntity channelEntity){
 	try {
			BeanUtils.copyProperties(this, channelEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
