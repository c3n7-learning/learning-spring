package tech.c3n7.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Coach theCoach = context.getBean("tennisCoach", Coach.class);

        Coach otherCoach = context.getBean("tennisCoach", Coach.class);

        Boolean result = (theCoach == otherCoach);

        System.out.println("\nPointing to the same object: " + result);

        System.out.println("\nMemory location of theCoach " + theCoach);
        System.out.println("\nPointing to the same otherCoach: " + otherCoach);

        context.close();
    }
}
