package tech.c3n7.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.c3n7.aopdemo.dao.AccountDAO;
import tech.c3n7.aopdemo.service.TrafficFortuneService;

import java.util.List;

public class AroundDemoApp {
    public static void main(String[] args) {

        // read spring configuration java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        System.out.println("\nMain Program: AroundDemoApp");

        System.out.println("Calling getFortune");

        String data = theFortuneService.getFortune();
        System.out.println("\nMy fortune is: " + data);

        System.out.println("Finished");

        // close the context
        context.close();
    }
}
