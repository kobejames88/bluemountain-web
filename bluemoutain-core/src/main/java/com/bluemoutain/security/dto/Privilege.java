/****************************************************
 * Description: Entity for 权限
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      xjj
 * @version     1.0
**************************************************/

package com.bluemoutain.security.dto;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Collection;
import java.util.Random;

public class Privilege {

    private static final long serialVersionUID = 1L;

    public Privilege(){}
    public Privilege(Long id){
        this.id = id;
    }

    private Long id = new Random().nextLong();
    private String code;//代码
    private String title;//名称
    private String desc;//描述
    private String url;//对应访问地址
    private Collection<Function> functions;//功能

    /**
     * @return 主键
     */
    public Long getId() {
        return id;
    }
    /**
     * @param
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * @return 代码
     */
    public String getCode() {
        return code;
    }
    
    /**
     * @param
     */
    public void setCode(String code) {
        this.code = code;
    }
    
    /**
     * @return 名称
     */
    public String getTitle() {
        return title;
    }
    
    /**
     * @param
     */
    public void setTitle(String title) {
        this.title = title;
    }
    
    /**
     * @return 描述
     */
    public String getDesc() {
        return desc;
    }
    
    /**
     * @param
     */
    public void setDesc(String desc) {
        this.desc = desc;
    }
    
    /**
     * @return 对应访问地址
     */
    public String getUrl() {
        return url;
    }
    
    /**
     * @param
     */
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * @return 功能
     */
    public Collection<Function> getFunctions() {
    	if(this.functions == null){
    		return null;
    	}
        return this.functions;
    }
	
    /**
     * @param
     */
    public void setFunctions(Collection<Function> functions) {
    	this.functions=functions;
    }

	
    /**
     * @param
     */
    public void removeFunction(Function function) {
    	if(function == null || function.getCode() == null){
    		return;
    	}
        this.functions.remove(function.getCode());
    }
    /**
     * 判断是否包含功能
     * @param function 功能
     * @return
     */
    public boolean hasFunction(Function function){
    	if(function == null || function.getCode() == null){
    		return false;
    	}
    	Function functionExits=getFunction(function.getCode());
    	if(functionExits!=null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * 判断是否包含功能
     * @param functionCode 功能代码
     * @return
     */
    public boolean hasFunction(String functionCode){
    	if(functionCode == null ){
    		return false;
    	}
    	Function function=getFunction(functionCode);
    	if(function!=null){
    		return true;
    	}else{
    		return false;
    	}
    }
    
    /**
     * 返回对应的功能
     * @param functionCode
     * @return
     */
    public Function getFunction(String functionCode){
    	if(this.functions == null || this.functions.size() == 0 || functionCode == null ){
    		return null;
    	}
    	for(Function function :functions){
    		if(function.getCode().equals(functionCode)){
    			return function;
    		}
    	}
    	return null;
    }

    public int hashCode() {
        return new HashCodeBuilder().append("com.xjj.framework.security.dto.Privilege").append(this.getCode()).toHashCode();
    }

    public boolean equals(Object obj) {
    	if(obj==null) return false;
        if (this == obj)
            return true;
        if (getClass() != obj.getClass())
            return false;
        if (!(obj instanceof Privilege))
            return false;
        final Privilege that = (Privilege)obj;
        return new EqualsBuilder().append(this.getCode(), that.getCode()).isEquals();
    }

    public String toString() {
		return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE)
				.append("com.xjj.framework.security.dto.Privilege")
				.append(",code=" + this.getCode())
				.append(",title=" + this.getTitle())
				.append(",url="+this.getUrl()).toString();
    }

}

