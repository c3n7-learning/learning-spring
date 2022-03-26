package tech.c3n7.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TennisCoach implements Coach {
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(@Qualifier("cutThroatFortuneService") FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }

    public TennisCoach() {
        System.out.println(">> Inside default constructor");
    }

//    @Autowired
//    public void setFortuneService(@Qualifier("happyFortuneService")FortuneService theFortuneService) {
//        System.out.println(">> Inside setter method");
//        fortuneService = theFortuneService;
//    }

    @Autowired
    public void aCrazyMethod(@Qualifier("cutThroatFortuneService")FortuneService theFortuneService) {
        System.out.println(">> Inside setter method");
        fortuneService = theFortuneService;
    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
