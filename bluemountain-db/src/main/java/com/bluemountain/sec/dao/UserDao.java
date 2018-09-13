package com.bluemountain.sec.dao;

import com.bluemountain.sec.entity.XjjUser;
import com.bluemoutain.dao.XjjDAO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface UserDao  extends XjjDAO<XjjUser> {
	public List<XjjUser> managerPage(@Param("query") HashMap<String, HashMap<String, Object>> queryMap, @Param("offset") int offset, @Param("limit") int limit);
}
