package com.bluemountain.modules.expressCompany.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;
import com.bluemountain.modules.expressCompany.entity.ExpressCompanyEntity;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;


/**
 * 
 * 
 * @author liuqi
 * @email 363236211@qq.com
 * @date 2018-06-06 13:08:58
 */
@TableName("cn_express_company")
@ApiModel(value = "ExpressCompany")
public class ExpressCompanyView  extends ExpressCompanyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public ExpressCompanyView(){
	}
 
 	public ExpressCompanyView(ExpressCompanyEntity expressCompanyEntity){
 	
 		BeanUtils.copyProperties(this, expressCompanyEntity);
	}
}
