package com.bluemountain.modules.user.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.modules.user.entity.UserEntity;
import com.bluemountain.modules.user.entity.model.UserModel;
import com.bluemountain.modules.user.entity.view.UserView;
import com.bluemountain.modules.user.entity.vo.UserVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;


/**
 * 用户表
 *
 * @author xuchen
 * @email 171998110@qq.com
 * @date 2018-06-30 13:40:24
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<UserVO> selectListVO(Wrapper<UserEntity> wrapper);
   	
   	UserVO selectVO(@Param("ew") Wrapper<UserEntity> wrapper);
   	
   	List<UserView> selectListView(Wrapper<UserEntity> wrapper);
   	
   	UserView selectView(@Param("ew") Wrapper<UserEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params, Wrapper<UserEntity> wrapper);

	PageUtils queryPage(Map<String, Object> params, UserModel userModel);
}

