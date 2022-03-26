package tech.c3n7.springdemo;

public class SadFortuneService implements FortuneService{
    @Override
    public String getFortune() {
        return "What a sad sad day. Any way to make it less so?";
    }
}
