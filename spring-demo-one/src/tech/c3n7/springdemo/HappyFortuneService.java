package tech.c3n7.springdemo;

public class HappyFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Get strapped or get clapped";
	}
}
