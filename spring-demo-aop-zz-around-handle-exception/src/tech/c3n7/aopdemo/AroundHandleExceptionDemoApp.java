package tech.c3n7.aopdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import tech.c3n7.aopdemo.service.TrafficFortuneService;

import java.util.logging.Logger;

public class AroundHandleExceptionDemoApp {
    private static Logger myLogger =
            Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());

    public static void main(String[] args) {

        // read spring configuration java class
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

        // get the bean from the spring container
        TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);

        myLogger.info("\nMain Program: AroundDemoApp");

        myLogger.info("Calling getFortune");

        String data = theFortuneService.getFortune();
        myLogger.info("\nMy fortune is: " + data);

        myLogger.info("Finished");

        // close the context
        context.close();
    }
}
