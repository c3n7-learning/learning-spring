package tech.c3n7.springdemo;

public class MyApp {

	public static void main(String[] args) {
		FortuneService fs = new HappyFortuneService();
		
		// create object
		Coach theCoach = new TrackCoach(fs);
		
		// use object
		System.out.println(theCoach.getDailyWorkout());
	}

}
