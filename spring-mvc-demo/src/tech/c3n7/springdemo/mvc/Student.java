package tech.c3n7.springdemo.mvc;

import java.util.LinkedHashMap;

public class Student {
    private String firstName;
    private String lastName;
    private String country;
    private String favoriteLanguage;

    private final LinkedHashMap<String, String> countryOptions;
    private LinkedHashMap<String, String> favoriteLanguageOptions;

    public Student() {
        countryOptions = new LinkedHashMap<>();
        countryOptions.put("KE", "Kenya");
        countryOptions.put("TZ", "Tanzania");
        countryOptions.put("ET", "Ethiopia");
        countryOptions.put("UG", "Uganda");
        countryOptions.put("SO", "Somalia");

        favoriteLanguageOptions = new LinkedHashMap<>();
        favoriteLanguageOptions.put("Python", "Python");
        favoriteLanguageOptions.put("Java", "Java");
        favoriteLanguageOptions.put("C++", "C++");
        favoriteLanguageOptions.put("Rust", "Rust");
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public LinkedHashMap<String, String> getCountryOptions() {
        return countryOptions;
    }

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public LinkedHashMap<String, String> getFavoriteLanguageOptions() {
        return favoriteLanguageOptions;
    }
}
