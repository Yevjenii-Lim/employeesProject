package com.yevhenii.spring.mvc_aop.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class MyLoggingAspect {

    @Around("execution (* com.yevhenii.spring.mvc_aop.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvise(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) proceedingJoinPoint.getSignature();

        String methodName = methodSignature.getName();
        System.out.println("begging of this " +methodName);
        Object targetMethodResult = proceedingJoinPoint.proceed();
        System.out.println("End of this method " + methodName);
        return targetMethodResult;
    }
}
