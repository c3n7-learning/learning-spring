package tech.c3n7.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.c3n7.aopdemo.dao.AccountDAO;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring configuration java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);

        // call the business method
        theAccountDAO.addAccount();

        // close the context
        context.close();
    }
}
