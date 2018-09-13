package modules.user.entity.view;

import com.baomidou.mybatisplus.annotations.TableName;

import io.swagger.annotations.ApiModel;
import modules.user.entity.UserEntity;
import org.apache.commons.beanutils.BeanUtils;

import java.io.Serializable;
import java.lang.reflect.InvocationTargetException;


/**
 * 用户表
 * 
 * @author liuqi
 * @email 171998110@qq.com
 * @date 2018-05-19 13:46:34
 */
@TableName("cn_user")
@ApiModel(value = "User")
public class UserView  extends UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public UserView(){
	}
 
 	public UserView(UserEntity userEntity){
 	
 		try {
			BeanUtils.copyProperties(this, userEntity);
		} catch (IllegalAccessException e) {
 			e.printStackTrace();
		} catch (InvocationTargetException e) {
 			e.printStackTrace();
		}
	}
}
