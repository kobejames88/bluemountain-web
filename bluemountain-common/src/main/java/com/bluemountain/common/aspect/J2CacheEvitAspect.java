
package com.bluemountain.common.aspect;


import com.bluemountain.common.annotation.J2CacheEvit;
import net.oschina.j2cache.CacheChannel;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 如果手动创建缓存，请使用这个注解来删除缓存
 *
 * @author xc 171998110@qq.com
 * @since   2018-06-29
 */
@Aspect
@Component
public class J2CacheEvitAspect {
	@Autowired
	private CacheChannel cacheChannel;
	
	@Pointcut("@annotation(com.bluemountain.common.annotation.J2CacheEvit)")
	public void J2CacheEvitPointCut() { 
		
	}

	@Around("J2CacheEvitPointCut()")
	public Object around(ProceedingJoinPoint point) throws Throwable {
		// 执行方法
		Object result = point.proceed();
		J2CacheEvit(point);
		return result;
	}

	private void J2CacheEvit(ProceedingJoinPoint joinPoint) {
		MethodSignature signature = (MethodSignature) joinPoint.getSignature();
		Method method = signature.getMethod();

		J2CacheEvit j2CacheEvit = method.getAnnotation(J2CacheEvit.class);
		cacheChannel.clear(j2CacheEvit.value());
	}
}
