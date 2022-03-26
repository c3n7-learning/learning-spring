package tech.c3n7.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class CrysisCoach implements Coach{
    @Value("${foo.name}")
    private String name;
    @Value("${foo.team}")
    private String team;

    @Autowired
    @Qualifier("cutThroatFortuneService")
    private FortuneService fortuneService;

    @Override
    public String getDailyWorkout() {
        return String.format("Buy another GPU, Says %s from team %s", name, team);
    }

    @Override
    public String getDailyFortune() {
        return fortuneService.getFortune();
    }
}
