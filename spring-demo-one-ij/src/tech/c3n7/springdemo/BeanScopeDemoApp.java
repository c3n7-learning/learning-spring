package tech.c3n7.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContextBeanScope.xml");

        Coach theCoach = context.getBean("myCoach", Coach.class);

        Coach otherCoach = context.getBean("myCoach", Coach.class);

        System.out.println(theCoach == otherCoach ? "Singleton" : "Prototype");
        System.out.println("The Coach: " + theCoach);
        System.out.println("Other Coach: " + otherCoach);
    }
}
