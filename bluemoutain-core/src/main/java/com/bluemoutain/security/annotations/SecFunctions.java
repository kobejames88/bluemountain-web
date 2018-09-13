package com.bluemoutain.security.annotations;

import java.lang.annotation.*;

/**
 * 功能集合标注
 * @author xjj
 */
@Inherited
@Target( ElementType.METHOD )
@Retention(RetentionPolicy.RUNTIME)
public @interface SecFunctions {
	/**
	 * 功能集合
	 * @return
	 */
	public SecFunction[] value();
}
