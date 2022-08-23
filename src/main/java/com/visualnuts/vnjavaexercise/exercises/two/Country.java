package com.visualnuts.vnjavaexercise.exercises.two;

import java.util.List;
import java.util.Objects;

public class Country {
    private String country;
    private List<String> languages;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public List<String> getLanguages() {
        return languages;
    }

    public void setLanguages(List<String> languages) {
        this.languages = languages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country)) return false;
        Country country1 = (Country) o;
        return Objects.equals(country, country1.country) && Objects.equals(languages, country1.languages);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, languages);
    }

    @Override
    public String toString() {
        return "Country{" +
                "country='" + country + '\'' +
                ", languages=" + languages +
                '}';
    }
}