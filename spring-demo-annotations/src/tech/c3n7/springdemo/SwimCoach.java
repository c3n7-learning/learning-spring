package tech.c3n7.springdemo;

public class SwimCoach implements Coach{
    private FortuneService fortuneService;

    public SwimCoach(FortuneService theFortuneService){
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
}
