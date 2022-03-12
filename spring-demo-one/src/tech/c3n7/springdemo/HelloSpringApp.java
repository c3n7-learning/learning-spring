package tech.c3n7.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		// load spring configuration files
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve a bean from the spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		
		// call methods on bean
		
		System.out.println(theCoach.getDailyWorkout());
		
		// close context
		context.close();
	}

}
