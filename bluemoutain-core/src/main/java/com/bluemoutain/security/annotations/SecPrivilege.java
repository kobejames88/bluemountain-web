package com.bluemoutain.security.annotations;

import java.lang.annotation.*;

/**
 * 权限标注
 * @author xjj
 */
@Inherited
@Target( ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SecPrivilege {
	
	/**
	 * 	权限的名称，只写一个参数时，和title一样的效果；
	 * @return
	 */
	public String value() default "";
	
	/**
	 * 权限的名称
	 * @return
	 */
	public String title() default "";
	
	/**
	 * 权限的编码，全局必须唯一
	 * @return
	 */
	public String code() default "";
	
}
