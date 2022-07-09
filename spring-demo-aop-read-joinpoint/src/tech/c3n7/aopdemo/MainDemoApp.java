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
        Account myAccount = new Account();
        theAccountDAO.addAccount(myAccount, true);
        theMembershipDAO.addAccount();
        theMembershipDAO.addSillyMember();

        theAccountDAO.doWork();
        theMembershipDAO.goToSleep();

        // Call setters/getters
        theAccountDAO.setName("foobar");
        theAccountDAO.setServiceCode("silver");

        String name = theAccountDAO.getName();
        String code = theAccountDAO.getServiceCode();

        // close the context
        context.close();
    }
}
