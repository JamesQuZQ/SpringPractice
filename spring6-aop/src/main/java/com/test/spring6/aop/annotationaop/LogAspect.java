package com.test.spring6.aop.annotationaop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.SQLOutput;
import java.util.Arrays;

/**
 * Aspect class for logging
 */
@Aspect // aspect class
@Order(1) // Use order to define aspect precedence, lower numbers come first
@Component // ioc container
public class LogAspect {

    // Configure pointcut and advice type
    //
    // Pointcut Expression(seperated by space):
    // execution(
    //      [Access Modifier]
    //      [Return Type]  - use * for any access modifier and return type
    //      [Path to Method] - use * for any package / ..* any level within any package, can be used in the path
    //      [Method Name] - use * for any method / get* for any method starting with get
    //      [Method Args(comma seperated)] - use (..) for any param
    // )
    //
    // Advice: Before, After Returning, After Throwing, After (Finally), Around

    // Reuse Pointcut Expression
    @Pointcut("execution(public int com.test.spring6.aop.annotationaop.CalculatorImpl.*(..))")
    public void pointcut(){}


    @Before("execution(public int com.test.spring6.aop.annotationaop.CalculatorImpl.*(..))")
    public void beforeAllMethod(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        Object[] args = joinPoint.getArgs();
        System.out.println("Logger before, method name = " + methodName + "; params = " + Arrays.toString(args));
    }

    @AfterReturning(value="pointcut()", returning="result")
    public void afterAllMethod(JoinPoint joinPoint, Object result){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger after, method name = " + methodName + "; result = " + result.toString());
    }

    @AfterThrowing(value="pointcut()", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, Throwable ex){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger throw, method name = " + methodName + "; exception = " + ex.toString());
    }

    @After(value="pointcut()")
    public void afterThrowing(JoinPoint joinPoint){
        String methodName = joinPoint.getSignature().getName();
        System.out.println("Logger throw, method name = " + methodName);
    }

    @Around(value="pointcut()")
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
