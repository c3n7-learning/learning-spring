package tech.c3n7.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component
public class TennisCoach implements Coach {
    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

//    @Autowired
//    public TennisCoach(@Qualifier("cutThroatFortuneService") FortuneService theFortuneService) {
//        fortuneService = theFortuneService;
//    }

    public TennisCoach() {
        System.out.println(">> Inside default constructor");
    }

    @PostConstruct
    public void doMyStartupStuff() {
        System.out.println(">> TennisCoach: doMyStartupStuff");
    }

    @PreDestroy
    public void doMyCleanupStuff() {
        System.out.println(">> TennisCoach: doMyCleanupStuff");
    }

//    @Autowired
//    public void setFortuneService(@Qualifier("happyFortuneService")FortuneService theFortuneService) {
//        System.out.println(">> Inside setter method");
//        fortuneService = theFortuneService;
//    }

//    @Autowired
//    public void aCrazyMethod(@Qualifier("cutThroatFortuneService")FortuneService theFortuneService) {
//        System.out.println(">> Inside setter method");
//        fortuneService = theFortuneService;
//    }

    @Override
    public String getDailyWorkout() {
        return "Practice your backhand volley";
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
