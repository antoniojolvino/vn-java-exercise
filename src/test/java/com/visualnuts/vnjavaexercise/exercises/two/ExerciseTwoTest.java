package com.visualnuts.vnjavaexercise.exercises.two;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ExerciseTwoTest {

    @Autowired
    private ExerciseTwo exerciseTwo;

    @Test
    public void getAllCountries() throws Exception {
        List<Country> allCountries = exerciseTwo.getAllCountries();
        assertNotNull(allCountries);

        // Just printing to see the result
        System.out.println("##########################");
        System.out.println("ALL COUNTRIES");
        System.out.println("##########################");
        allCountries.forEach(System.out::println);
    }

    @Test
    public void getCountryWithMostLanguagesByLanguage(){
        Locale locale = Locale.GERMANY;
        Country countryWithMostLanguagesByLanguage = exerciseTwo.getCountryWithMostLanguagesByLanguage(locale);
        assertNotNull(countryWithMostLanguagesByLanguage);

        // Just printing to see the result
        System.out.println("##########################");
        System.out.println("COUNTRY WITH MOST LANGUAGES BY LANGUAGE [" + locale.getDisplayLanguage() + "]");
        System.out.println("##########################");
        System.out.println(countryWithMostLanguagesByLanguage);
    }

    @Test
    void countOfficialLanguages() {
        Integer countOfficialLanguages = exerciseTwo.countOfficialLanguages();
        assertTrue(countOfficialLanguages > 0);

        // Just printing to see the result
        System.out.println("##########################");
        System.out.println("COUNT OFFICIAL LANGUAGES");
        System.out.println("##########################");
        System.out.println(countOfficialLanguages);
    }

    @Test
    void getCountryWithMoreLanguages() {
        Country countryWithMoreLanguages = exerciseTwo.getCountryWithMoreLanguages();
        assertNotNull(countryWithMoreLanguages);

        // Just printing to see the result
        System.out.println("##########################");
        System.out.println("COUNTRY WITH MORE LANGUAGES");
        System.out.println("##########################");
        System.out.println(countryWithMoreLanguages);

    }

    @Test
    void getMostCommonLanguages() {
        List<String> mostCommonLanguages = exerciseTwo.getMostCommonLanguages();
        assertNotNull(mostCommonLanguages);

        // Just printing to see the result
        System.out.println("##########################");
        System.out.println("MOST COMMON LANGUAGE(S)");
        System.out.println("##########################");
        mostCommonLanguages.forEach(System.out::println);
    }
}