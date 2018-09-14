package com.bluemountain.modules.channel.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-08 14:46:17
 */
@TableName("cn_channel")
@ApiModel(value = "Channel")
public class ChannelEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ChannelEntity() {
		
	}
	
	public ChannelEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	
	@TableId 				 
	@ApiModelProperty(value = "",hidden = true)
	private Long channelId;
	
	/**
	 * 频道名称
	 */
					 
	@ApiModelProperty(value = "频道名称")
	private String name;
	
	/**
	 * 
	 */
					 
	@ApiModelProperty(value = "")
	private Integer sort;
	
	/**
	 * 是否展示（0展示，1不展示）
	 */
					 
	@ApiModelProperty(value = "是否展示（0展示，1不展示）")
	private Integer isShow;
	
	/**
	 * 模式 1:商城 2：服务
	 */
					 
	@ApiModelProperty(value = "模式 1:商城 2：服务")
	private Integer model;
	
	/**
	 * 设置：
	 */
	public void setChannelId(Long channelId) {
		this.channelId = channelId;
	}
	/**
	 * 获取：
	 */
	public Long getChannelId() {
		return channelId;
	}
	/**
	 * 设置：频道名称
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * 获取：频道名称
	 */
	public String getName() {
		return name;
	}
	/**
	 * 设置：
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：是否展示（0展示，1不展示）
	 */
	public void setIsShow(Integer isShow) {
		this.isShow = isShow;
	}
	/**
	 * 获取：是否展示（0展示，1不展示）
	 */
	public Integer getIsShow() {
		return isShow;
	}
	/**
	 * 设置：模式 1:商城 2：服务
	 */
	public void setModel(Integer model) {
		this.model = model;
	}
	/**
	 * 获取：模式 1:商城 2：服务
	 */
	public Integer getModel() {
		return model;
	}
}
