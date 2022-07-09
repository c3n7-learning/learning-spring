package tech.c3n7.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging
    @Pointcut("execution(* tech.c3n7.aopdemo.dao.*.*(..))")
    private void forDaoPackage() {}

    @Pointcut("execution(* tech.c3n7.aopdemo.dao.*.get*(..))")
    private void getters() {}

    @Pointcut("execution(* tech.c3n7.aopdemo.dao.*.set*(..))")
    private void setters() {}

    @Pointcut("forDaoPackage() && !(setters() || getters())")
    private void forDaoPackageNoGetterSetter() {}

    @Before("forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>> Executing @Before advice on method()");
    }

    @Before("forDaoPackageNoGetterSetter()")
    public void performApiAnalytics() {
        System.out.println("\n==========>>> Performing API Analytics");
    }
}
