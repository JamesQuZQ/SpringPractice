package com.test.spring6.aop.xmlaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * Aspect class for logging
 */

@Component // ioc container
public class LogAspect {

    public void beforeAllMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger before, method name = " + methodName + "; params = " + Arrays.toString(args));
    }

    public void afterReturningMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger return, method name = " + methodName + "; result：" + result.toString());
    }

    public void afterAllMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger after, method name = " + methodName);
    }

    public void afterThrowing(JoinPoint joinPoint, Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger throw, method name = " + methodName + "; exception = " + ex.toString());
    }

    public int aroundMethod(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        String methodName = proceedingJoinPoint.getSignature().getName();
        Object[] args = proceedingJoinPoint.getArgs();
        Object result = null;
        try {
            System.out.println("Around: Before method execution");
            result = proceedingJoinPoint.proceed(args);
            System.out.println("Around: After method return");
        } catch (Throwable throwable) {
            System.out.println("Around: Exception in method execution: " + throwable.getMessage());
            return 0;
        } finally {
            System.out.println("Around: After method execution");
        }
        return (int)result;
    }
}
