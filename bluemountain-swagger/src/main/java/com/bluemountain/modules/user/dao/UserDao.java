package com.bluemountain.modules.user.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.bluemountain.modules.user.entity.UserEntity;

import java.util.List;

/**
 * 用户表
 * 
 * @author liuqi
 * @email 171998110@qq.com
 * @date 2018-05-19 13:46:34
 */
public interface UserDao extends BaseMapper<UserEntity> {

	public List<UserEntity> queryUserLock(UserEntity ue);

}
