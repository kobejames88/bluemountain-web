package com.bluemoutain.security.annotations;

import java.lang.annotation.*;

/**
 * 权限集合标注
 * @author xjj
 */
@Inherited
@Target( ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecPrivileges {
	
	/**
	 * 	权限集合；
	 * @return
	 */
	public SecPrivilege[] value();
	
}
