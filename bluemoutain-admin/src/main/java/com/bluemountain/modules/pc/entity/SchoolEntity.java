package com.bluemountain.modules.pc.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.apache.commons.beanutils.BeanUtils;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 
 * 数据库通用操作实体类（普通增删改查）
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-20 12:40:06
 */
@TableName("t_school")
@ApiModel(value = "School")
public class SchoolEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public SchoolEntity() {
		
	}
	
	public SchoolEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * 学校id
	 */
	
	@TableId 					
	@ApiModelProperty(value = "学校id",hidden = true)
	private Long schoolId;
	
	/**
	 * 排序
	 */
				
	@NotBlank (message = "排序不能为空") 			
	@ApiModelProperty(value = "排序")
	private String schoolName;
	
	/**
	 * 排序
	 */
						
	@ApiModelProperty(value = "排序")
	private Integer sort;
	
	/**
	 * 备注
	 */
						
	@ApiModelProperty(value = "备注")
	private String remark;
	
	/**
	 * 设置：学校id
	 */
	public void setSchoolId(Long schoolId) {
		this.schoolId = schoolId;
	}
	/**
	 * 获取：学校id
	 */
	public Long getSchoolId() {
		return schoolId;
	}
	/**
	 * 设置：排序
	 */
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
	/**
	 * 获取：排序
	 */
	public String getSchoolName() {
		return schoolName;
	}
	/**
	 * 设置：排序
	 */
	public void setSort(Integer sort) {
		this.sort = sort;
	}
	/**
	 * 获取：排序
	 */
	public Integer getSort() {
		return sort;
	}
	/**
	 * 设置：备注
	 */
	public void setRemark(String remark) {
		this.remark = remark;
	}
	/**
	 * 获取：备注
	 */
	public String getRemark() {
		return remark;
	}
}
