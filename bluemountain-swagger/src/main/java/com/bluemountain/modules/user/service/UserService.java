package com.bluemountain.modules.user.service;


import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import com.bluemountain.form.LoginForm;
import com.bluemountain.form.PhoneForm;
import com.bluemountain.form.RegisterForm;
import com.bluemountain.modules.user.entity.UserEntity;

import java.util.Map;

/**
 * 用户表
 *
 * @author liuqi
 * @email 171998110@qq.com
 * @date 2018-05-19 13:46:34
 */
public interface UserService extends IService<UserEntity> {

    PageUtils queryPage(Map<String, Object> params);

	UserEntity queryByMobile(String mobile);

	Map<String, Object> login(LoginForm form);
	
	
	R register(RegisterForm form);

	Map speedRegister(PhoneForm form);
}

