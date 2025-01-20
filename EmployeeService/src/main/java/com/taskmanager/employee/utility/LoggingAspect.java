package com.taskmanager.employee.utility;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {
	
	private Log logger = LogFactory.getLog(LoggingAspect.class);
	
	@AfterThrowing(pointcut = "execution(* com.taskmanager.*.service.*Service*.*(..))", throwing="e")
	public void logging(Exception e) {
		logger.error(e.getMessage());
	}
	
}
