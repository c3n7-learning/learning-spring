package tech.c3n7.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class CRMLoggingAspect {
    // setup logger
    private Logger myLogger = Logger.getLogger(getClass().getName());

    // setup pointcut declarations
    @Pointcut("execution(* tech.c3n7.springdemo.controller.*.*(..))")
    private void forControllerPackage() {}

    @Pointcut("execution(* tech.c3n7.springdemo.service.*.*(..))")
    private void forServicePackage() {}

    @Pointcut("execution(* tech.c3n7.springdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("forControllerPackage() || forServicePackage() || forDaoPackage()")
    private void forAppFlow() {}

    // add @Before advice
    @Before("forAppFlow()")
    public void before(JoinPoint joinPoint) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        myLogger.info("=====> in @Before: calling method: " + methodSignature);

        Object[] args = joinPoint.getArgs();

        for(Object arg: args) {
            myLogger.info("=====> argument: " + arg);
        }
    }

    // add @AfterReturning advice
    @AfterReturning(pointcut = "forAppFlow()", returning = "theResult")
    public void afterReturning(JoinPoint joinPoint, Object theResult) {
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        myLogger.info("=====> in @AfterReturning: calling method: " + methodSignature);

        myLogger.info("=====> result: " + theResult);
    }
}
