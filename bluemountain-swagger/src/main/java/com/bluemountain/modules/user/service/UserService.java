package modules.user.service;


import com.baomidou.mybatisplus.service.IService;
import com.bluemountain.common.utils.PageUtils;
import com.bluemountain.common.utils.R;
import form.LoginForm;
import form.PhoneForm;
import form.RegisterForm;
import modules.user.entity.UserEntity;

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

