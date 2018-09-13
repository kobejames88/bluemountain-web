package com.bluemountain;

import com.baomidou.mybatisplus.mapper.MetaObjectHandler;
import com.bluemountain.modules.sys.shiro.ShiroUtils;
import org.apache.ibatis.reflection.MetaObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

//@Component
public class MyMetaObjectHandler extends MetaObjectHandler {

	    protected final static Logger logger = LoggerFactory.getLogger(AdminApplication.class);

	    @Override
	    public void insertFill(MetaObject metaObject) {
   	        logger.info("新增的时候干点不可描述的事情");
	        setFieldValByName("createTime", new Date(), metaObject);
	        setFieldValByName("createBy", ShiroUtils.getUserEntity().getUsername(), metaObject);
	    }

	    @Override
	    public void updateFill(MetaObject metaObject) {
	        logger.info("更新的时候干点不可描述的事情");
	        setFieldValByName("updateTime", new Date(), metaObject);
	        setFieldValByName("updateBy", ShiroUtils.getUserEntity().getUsername(), metaObject);
	    }

}
