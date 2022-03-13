package tech.c3n7.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CrysisCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Buy another GPU";
    }
}
