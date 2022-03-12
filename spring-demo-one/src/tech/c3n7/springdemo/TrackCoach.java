package tech.c3n7.springdemo;

public class TrackCoach implements Coach {
	private FortuneService fortuneService;
	
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Run 24 laps across the field";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return "Listen kid: " + fortuneService.getFortune();
	}

}
