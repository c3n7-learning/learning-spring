package tech.c3n7.aopdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import tech.c3n7.aopdemo.Account;

import java.util.List;

@Aspect
@Component
@Order(2)
public class MyDemoLoggingAspect {

    @Around("execution(* tech.c3n7.aopdemo.service.*.getFortune(..))")
    public Object aroundGetFortune(ProceedingJoinPoint theProceedingJoinPoint) throws Throwable {
        String method = theProceedingJoinPoint.getSignature().toShortString();
        System.out.println("\n==========>>> Executing @Around on " + method);

        long begin = System.currentTimeMillis();
        Object result = theProceedingJoinPoint.proceed();

        // get end timestamp
        long end = System.currentTimeMillis();
        long duration = end - begin;

        System.out.println("\n==========>>> Duration: " + duration / 1000.00  + " seconds");

        return result;
    }

    @After("execution(* tech.c3n7.aopdemo.dao.AccountDAO.findAccounts(..))")
    public void afterFinallyFindAccountsAdvice(JoinPoint joinPoint) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n==========>>> Executing @After (finally) on " + method);
    }

    @AfterThrowing(pointcut = "execution(* tech.c3n7.aopdemo.dao.AccountDAO.findAccounts(..))",
            throwing = "exc"
    )
    public void afterThrowingFindAccountsAdvice(JoinPoint joinPoint, Throwable exc) {
        String method = joinPoint.getSignature().toShortString();
        System.out.println("\n==========>>> Executing @AfterThrowing on " + method);

        System.out.println("==========>>> Exception: " + exc);
    }

    @AfterReturning(pointcut = "execution(* tech.c3n7.aopdemo.dao.AccountDAO.findAccounts(..))",
            returning = "result"
    )
    public void afterReturningFindAccountsAdvice(JoinPoint joinPoint, List<Account> result) {
        String method = joinPoint.getSignature().toShortString();

        System.out.println("\n==========>>> Executing @AfterReturning on " + method);
        System.out.println("==========>>> result is: " + result);

        // post-process the data
        convertAccountNamesToUppercase(result);
        System.out.println("==========>>> modified result is: " + result);
    }

    private void convertAccountNamesToUppercase(List<Account> result) {
        for(Account tempAccount: result) {
            String upper = tempAccount.getName().toUpperCase();
            tempAccount.setName(upper);
        }
    }

    @Before("tech.c3n7.aopdemo.aspect.AopExpressions.forDaoPackageNoGetterSetter()")
    public void beforeAddAccountAdvice(JoinPoint theJoinPoint) {
        System.out.println("\n==========>>> Executing @Before advice on method()");

        // display the method signature
        MethodSignature methodSig = (MethodSignature) theJoinPoint.getSignature();
        System.out.println("Method : " + methodSig);

        // diplay method arguments
        Object[] args = theJoinPoint.getArgs();

        for (Object tempArg : args) {
            System.out.println(tempArg);

            if(tempArg instanceof Account) {
                // downcast and print Account specific stuff
                Account theAccount = (Account) tempArg;

                System.out.println("account name: " + theAccount.getName());
                System.out.println("account level: " + theAccount.getLevel());
            }
        }
    }
}
