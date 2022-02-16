package com.mouritech.springbootsecurityrestexample.aspect;


import java.util.Arrays;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {
	
	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Pointcut("within(org.springframework.stereotype.Repository)" 
			+ "|| within(org.springframework.stereotype.Service)" 
			+ "|| within(org.springframework.web.bind.annotation.RestController)")
	public void springBeanPointcut() {
		//empty method because these are just pointcuts ,where implementations are done in advices
		
	}

	@Pointcut("within(com.mouritech.springbootsecurityrestexample.repository.*)" 
			+ "|| within(com.mouritech.springbootsecurityrestexample.Service.*)" 
			+ "|| within(com.mouritech.springbootsecurityrestexample.controller.AuthController)")
	public void applicationPackagePointcut() {
		//empty method because these are just pointcuts ,where implementations are done in advices
		
	}
	
	@AfterThrowing(pointcut = "applicationPackagePointcut() && applicationPackagePointcut()" 
			,throwing = "e")
	public void logAfterThrowing(JoinPoint joinPoint,Throwable e){
		log.error("Exception in {}.{} with cause = {}",joinPoint.getSignature().getDeclaringTypeName(),
				joinPoint.getSignature().getName(),e.getCause()!= null ? e.getCause() : "NULL");
	}
	
	  /**
     * Advice that logs when a method is entered and exited.
     *
     * @param joinPoint join point for advice
     * @return result
     * @throws Throwable throws IllegalArgumentException
     */
    
    @Around( "applicationPackagePointcut() && springBeanPointcut()")
    public Object logAround(ProceedingJoinPoint joinPoint) throws Throwable {
    	
    	if(log.isDebugEnabled()) {
    		log.debug("Enter:{}.{}() with result = {}",joinPoint.getSignature().getDeclaringTypeName() ,
    				joinPoint.getSignature().getName(),Arrays.toString(joinPoint.getArgs()));
    	}
    	
    	try {
    		Object result = joinPoint.proceed();
    		if(log.isDebugEnabled()) {
        		log.debug("Enter:{}.{}() with result = {}",joinPoint.getSignature().getDeclaringTypeName() ,
        				joinPoint.getSignature().getName(),result);
    		}
    		return result;
    		
    	}catch(IllegalArgumentException e) {
    		log.error("Illegal Argument : {} in {} . {}()",Arrays.toString(joinPoint.getArgs()),
    				joinPoint.getSignature().getDeclaringTypeName() ,	joinPoint.getSignature().getName());
    		
    		throw e;
    	}
    	
    }
	
}
