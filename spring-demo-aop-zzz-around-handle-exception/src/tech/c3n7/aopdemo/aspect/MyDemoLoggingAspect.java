package tech.c3n7.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tech.c3n7.aopdemo.Account;

import java.util.List;
import java.util.logging.Logger;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    private Logger myLogger = Logger.getLogger(getClass().getName());

    @Around("execution(* tech.c3n7.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        myLogger.info("\n==========>>> Executing @Around on " + method);

        long begin = System.currentTimeMillis();

        Object result = null;
        try {
            result = theProceedingJoinPoint.proceed();
        } catch (Exception e) {
            myLogger.warning(e.getMessage());

            throw e;
        }

        // get end timestamp
        long end = System.currentTimeMillis();
        long duration = end - begin;

        myLogger.info("\n==========>>> Duration: " + duration / 1000.00  + " seconds");

        return result;
    }

    @After("execution(* tech.c3n7.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n==========>>> Executing @After (finally) on " + method);
    }

    @AfterThrowing(pointcut = "execution(* tech.c3n7.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        myLogger.info("\n==========>>> Executing @AfterThrowing on " + method);

        myLogger.info("==========>>> Exception: " + exc);
    }

    @AfterReturning(pointcut = "execution(* tech.c3n7.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();

        myLogger.info("\n==========>>> Executing @AfterReturning on " + method);
        myLogger.info("==========>>> result is: " + result);

        // post-process the data
        convertAccountNamesToUppercase(result);
        myLogger.info("==========>>> modified result is: " + result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for(Account tempAccount: result) {
            String upper = tempAccount.getName().toUpperCase();
            tempAccount.setName(upper);
        }
    }

    @Before("tech.c3n7.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        myLogger.info("\n==========>>> Executing @Before advice on method()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        myLogger.info("Method : " + methodSig);

        // diplay method arguments
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            myLogger.info((String) tempArg);

            if(tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                myLogger.info("account name: " + theAccount.getName());
                myLogger.info("account level: " + theAccount.getLevel());
            }
        }
    }
}
