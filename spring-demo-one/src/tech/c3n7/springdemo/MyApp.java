package tech.c3n7.springdemo;

public class MyApp {

	public static void main(String[] args) {
		// create object
		Coach theCoach = new TrackCoach();
		
		// use object
		System.out.println(theCoach.getDailyWorkout());
	}

}
