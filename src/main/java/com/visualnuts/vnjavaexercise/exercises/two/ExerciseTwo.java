package com.visualnuts.vnjavaexercise.exercises.two;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Image you have a set of data in JSON, describing official languages spoken by countries, such as: <strong>"countries.json"</strong>
 * <br/>
 * Write a function in Java that:
 * <br/>
 * - returns the number of countries in the world
 * <br/>
 * - finds the country with the most official languages, where they officially speak German (de).
 * <br/>
 * - that counts all the official languages spoken in the listed countries.
 * <br/>
 * - to find the country with the highest number of official languages.
 * <br/>
 * - to find the most common official language(s), of all countries.
 */
@Service
public class ExerciseTwo {

    public final List<Country> countries;

    public ExerciseTwo(@Value("${exercise.two.json-file}") Resource resourceFile) {
        try {
            countries = List.of(new ObjectMapper().readValue(resourceFile.getFile(), Country[].class));
        } catch (IOException e) {
            throw new RuntimeException("There was a problem loading countries from file", e);
        }
    }

    /**
     * returns the number of countries in the world
     *
     * @return List of Country
     */
    public List<Country> getAllCountries() {
        return countries;
    }

    /**
     * finds the country with the most official languages, where they officially speak German (de).
     *
     * @param locale
     * @return
     */
    public Country getCountryWithMostLanguagesByLanguage(Locale locale) {

        Country country = null;
        int countLang = 0;

        for (Country c : countries) {
            if(c.getLanguages().contains(locale.getLanguage()) && c.getLanguages().size() > countLang){
                country = c;
                countLang = c.getLanguages().size();
            }
        }

        return country;
    }

    /**
     * that counts all the official languages spoken in the listed countries.
     *
     * @return
     */
    public Integer countOfficialLanguages() {
        List<String> officialLanguages = new ArrayList<>();
        countries.forEach(
                country -> country.getLanguages().forEach(
                        language -> {
                            if(!officialLanguages.contains(language)){
                                officialLanguages.add(language);
                            }
                        }
                )
        );

        return officialLanguages.size();
    }

    /**
     * to find the country with the highest number of official languages.
     *
     * @return
     */
    public Country getCountryWithMoreLanguages() {
        Country country = null;
        int countLang = 0;

        for (Country c : countries) {
            if(c.getLanguages().size() > countLang){
                country = c;
                countLang = c.getLanguages().size();
            }
        }

        return country;
    }

    /**
     * to find the most common official language(s), of all countries.
     *
     * @return
     */
    public List<String> getMostCommonLanguages() {

        Map<String, Integer> countLanguages = new HashMap<>();
        // Counts each language building a Map
        countries.forEach(
                country -> country.getLanguages().forEach(
                        language -> countLanguages.put(language, Optional.ofNullable(countLanguages.get(language)).orElse(0) + 1)
                )
        );

        // Gets the max value from the Map
        Optional<Integer> maxLanguage = countLanguages.values().stream().max(Comparator.naturalOrder());

        // Gets every language that has the max value
        return maxLanguage.map(
                        integer -> countLanguages.entrySet().stream().filter(
                                        entry -> entry.getValue().equals(integer)
                                )
                                .map(Map.Entry::getKey)
                                .collect(Collectors.toList()))
                .orElseGet(List::of);
    }
}
