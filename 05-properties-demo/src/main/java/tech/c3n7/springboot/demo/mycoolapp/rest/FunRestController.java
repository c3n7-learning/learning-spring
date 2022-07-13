package tech.c3n7.springboot.demo.mycoolapp.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class FunRestController {

    @Value("${coach.name}")
    private String coachName;

    @Value("${team.name}")
    private String teamName;

    @GetMapping("/")
    public String sayHello() {
        return "Hello Interesting World! Time on server is  " + LocalDateTime.now();
    }

    @GetMapping("/workout")
    public String getDailyWorkout() {
        return "Run a hard 5k! Like a real man! Hear me?";
    }

    @GetMapping("/teaminfo")
    public String getTeamInfo() {
        return "Such a great coach " + coachName + " for such a great team by the name " + teamName;
    }
}
