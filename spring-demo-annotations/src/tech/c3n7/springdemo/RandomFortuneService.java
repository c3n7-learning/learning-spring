package tech.c3n7.springdemo;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class RandomFortuneService implements FortuneService{
    private String[] data = {
            "Beware of the wolf in sheep's clothing",
            "Baniani mbaya kiatu chake dawa",
            "Mwenda tenzi na omo marejeo ni ngamani",
            "Asiyesikia la mkuu huvunjika guu",
            "Cha mwanafuu mkufuu ha akila hufa"
    };

    private Random random = new Random();

    @Override
    public String getFortune() {
        int index = random.nextInt(data.length);

        return data[index];
    }
}
