/****************************************************
 * Description: ServiceImpl for 评论
 * Copyright:   Copyright (c) 2018
 * Company:     xjj
 * @author      zhanghejie
 * @version     1.0
 * @see
	HISTORY
    *  2018-07-04 zhanghejie Create File
**************************************************/

package com.bluemountain.service.impl;


import com.bluemountain.customer.comment.dao.CommentDao;
import com.bluemountain.customer.comment.entity.CommentEntity;
import com.bluemountain.service.CommentService;
import com.bluemoutain.dao.XjjDAO;
import com.bluemoutain.service.XjjServiceSupport;
import com.bluemoutain.web.support.XJJParameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class CommentServiceImpl extends XjjServiceSupport<CommentEntity> implements CommentService {

	@Autowired
	private CommentDao commentDao;

	@Override
	public XjjDAO<CommentEntity> getDao() {
		
		return commentDao;
	}
	
	public int count(Integer type, Integer valueId, Integer showType){
        //查询用户的足迹
        XJJParameter param = new XJJParameter();
        if(showType== 0) {
        	param.addQuery("query.typeId@eq@i", type);
        	param.addQuery("query.valueId@eq@l", valueId);
        }
        else if(showType == 1){
            param.addQuery("query.typeId@eq@i", type);
        	param.addQuery("query.valueId@eq@l", valueId);
        	param.addQuery("query.hasPicture@eq@i", 1);
        }else
        {
        	Assert.state(false, "");
        }
        return commentDao.getCount(param.getQueryMap());
    }
	
	 public List<CommentEntity> query(Integer type, Integer valueId, Integer showType, Integer page, Integer size) {
		 	XJJParameter param = new XJJParameter();
		 	param.addOrderByDesc("addTime");
		 	
	        if(showType == 0) {
	        	param.addQuery("query.typeId@eq@i", type);
	        	param.addQuery("query.valueId@eq@l", valueId);
	        }
	        else if(showType == 1){
	        	param.addQuery("query.typeId@eq@i", type);
	         	param.addQuery("query.valueId@eq@l", valueId);
	         	param.addQuery("query.hasPicture@eq@i", 1);
	        }
	        else{
	            Assert.state(false, "showType不支持");
	        }
	        return commentDao.findListLimit(param.getQueryMap(), (page-1)*size, size);
	    }
}