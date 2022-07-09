package tech.c3n7.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

    // this is where we add all of our related advices for logging

    // start with a @Before advice
//    @Before("execution(public void addAccount())")
//    @Before("execution(public void tech.c3n7.aopdemo.dao.AccountDAO.addAccount())")
    @Before("execution(* add*(..))")
    public void beforeAddAccountAdvice() {
        System.out.println("\n==========>>> Executing @Before advice on method()");
    }
}
