package tech.c3n7.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AopExpressions {
    // this is where we add all of our related advices for logging
    @Pointcut("execution(* tech.c3n7.aopdemo.dao.*.*(..))")
    public void forDaoPackage() {}

    @Pointcut("execution(* tech.c3n7.aopdemo.dao.*.get*(..))")
    public void getters() {}

    @Pointcut("execution(* tech.c3n7.aopdemo.dao.*.set*(..))")
    public void setters() {}

    @Pointcut("forDaoPackage() && !(setters() || getters())")
    public void forDaoPackageNoGetterSetter() {}
}
