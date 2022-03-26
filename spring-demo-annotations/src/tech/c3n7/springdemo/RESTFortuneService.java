package tech.c3n7.springdemo;

import org.springframework.stereotype.Component;

@Component
public class RESTFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "RESTFul will you be.";
    }
}
