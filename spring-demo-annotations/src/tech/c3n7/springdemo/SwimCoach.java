package tech.c3n7.springdemo;


import org.springframework.beans.factory.annotation.Value;

public class SwimCoach implements Coach {
    private final FortuneService fortuneService;

    @Value("${foo.email}")
    private String email;
    @Value("${foo.team}")
    private String team;

    public SwimCoach(FortuneService theFortuneService) {
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Do a mean back stroke today";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }

    public String getEmail() {
        return email;
    }

    public String getTeam() {
        return team;
    }
}
