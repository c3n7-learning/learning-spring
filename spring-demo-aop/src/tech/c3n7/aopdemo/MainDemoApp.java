package tech.c3n7.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.c3n7.aopdemo.dao.AccountDAO;
import tech.c3n7.aopdemo.dao.MembershipDAO;

public class MainDemoApp {
    public static void main(String[] args) {

        // read spring configuration java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        AccountDAO theAccountDAO = context.getBean("accountDAO", AccountDAO.class);
        MembershipDAO theMembershipDAO = context.getBean("membershipDAO", MembershipDAO.class);

        // call the business method
        theAccountDAO.addAccount();
        theMembershipDAO.addAccount();
        theMembershipDAO.addSillyMember();

        // close the context
        context.close();
    }
}
