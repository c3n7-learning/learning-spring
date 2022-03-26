package tech.c3n7.springdemo;

import org.springframework.stereotype.Component;

@Component
public class CutThroatFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "This isn't a game! Lives are at stake";
    }
}
