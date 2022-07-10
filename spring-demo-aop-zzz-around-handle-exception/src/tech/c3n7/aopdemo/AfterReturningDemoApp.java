package tech.c3n7.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.c3n7.aopdemo.dao.AccountDAO;

import java.util.List;

public class AfterReturningDemoApp {
    public static void main(String[] args) {

        // read spring configuration java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        boolean tripWire = true;
        List<Account> theAccounts = theAccountDAO.findAccounts(tripWire);

        System.out.println("\n\nMainProgram: AfterReturningDemoApp");
        System.out.println("-----");
        System.out.println(theAccounts);
        System.out.println("\n");

        // close the context
        context.close();
    }
}
