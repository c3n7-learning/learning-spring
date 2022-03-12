package tech.c3n7.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SetterDemoApp {

	public static void main(String[] args) {
		// load spring configuration files
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve a bean from the spring container
		ForzaCoach theCoach = context.getBean("myForzaCoach", ForzaCoach.class);
		
		// call methods on bean
		
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		System.out.println(theCoach.getEmailAddress());
		System.out.println(theCoach.getTeam());
		
		// close context
		context.close();

	}

}
