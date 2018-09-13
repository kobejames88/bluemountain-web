package com.bluemoutain.web.support;

import java.lang.annotation.*;

/**
 * 查询参数标注
 *
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface QueryParameter {

	public static final String DEFAULT_QUERY_NAME = "query";
	/**
	 * The name of the request parameter to bind to.
	 */
	String value() default DEFAULT_QUERY_NAME;

}