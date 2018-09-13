package com.bluemountain.modules.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.bluemountain.modules.user.entity.UserEntity;
import com.bluemountain.modules.user.entity.view.UserView;
import com.bluemountain.modules.user.entity.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户表
 * 
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-30 13:40:24
 */
public interface UserDao extends BaseMapper<UserEntity> {
	
	List<UserVO> selectListVO(@Param("ew") Wrapper<UserEntity> wrapper);
	
	UserVO selectVO(@Param("ew") Wrapper<UserEntity> wrapper);
	
	
	List<UserView> selectListView(@Param("ew") Wrapper<UserEntity> wrapper);

	List<UserView> selectListView(Pagination page, @Param("ew") Wrapper<UserEntity> wrapper);
	
	UserView selectView(@Param("ew") Wrapper<UserEntity> wrapper);
}
