package com.bluemountain.modules.expressCompany.entity;

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
 * @date 2018-06-06 13:08:58
 */
@TableName("cn_express_company")
@ApiModel(value = "ExpressCompany")
public class ExpressCompanyEntity<T> implements Serializable {
	private static final long serialVersionUID = 1L;


	public ExpressCompanyEntity() {
		
	}
	
	public ExpressCompanyEntity(T t) {
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
	private Integer id;
	
	/**
	 * 快递公司编号
	 */
					 
	@ApiModelProperty(value = "快递公司编号")
	private String companyNumber;
	
	/**
	 * 快递公司名称
	 */
					 
	@ApiModelProperty(value = "快递公司名称")
	private String companyName;
	
	/**
	 * 设置：
	 */
	public void setId(Integer id) {
		this.id = id;
	}
	/**
	 * 获取：
	 */
	public Integer getId() {
		return id;
	}
	/**
	 * 设置：快递公司编号
	 */
	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}
	/**
	 * 获取：快递公司编号
	 */
	public String getCompanyNumber() {
		return companyNumber;
	}
	/**
	 * 设置：快递公司名称
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * 获取：快递公司名称
	 */
	public String getCompanyName() {
		return companyName;
	}
}
