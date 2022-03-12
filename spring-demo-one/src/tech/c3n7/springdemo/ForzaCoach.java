package tech.c3n7.springdemo;

public class ForzaCoach implements Coach {
	private FortuneService fortuneService;
	
	public ForzaCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside setter method");
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Do PvP practice sessions";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
