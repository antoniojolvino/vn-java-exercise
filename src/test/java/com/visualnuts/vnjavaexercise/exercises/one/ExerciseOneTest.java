package com.visualnuts.vnjavaexercise.exercises.one;

import com.visualnuts.vnjavaexercise.exercises.one.ExerciseOne;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.regex.Pattern;


@SpringBootTest
class ExerciseOneTest {
    @Autowired
    ExerciseOne exerciseOne;

    @Test
    @DisplayName("Executing and testing exercise One")
    void execute() {
        System.out.println("#############################");
        System.out.println("EXERCISE 1 START");
        System.out.println("#############################");
        exerciseOne.executeAndPrint();
        System.out.println("#############################");
        System.out.println("EXERCISE 1 END");
        System.out.println("#############################");

        Integer maxValue = exerciseOne.getMaxValue();
        String[] output = exerciseOne.getOutput();

        Assertions.assertEquals(maxValue, output.length);
        for (String value: output) {
            Assertions.assertNotNull(value);

            // Pattern to define if value is an integer
            Pattern pattern = Pattern.compile("\\d+");
            if(pattern.matcher(value).matches()){
                Assertions.assertFalse(Integer.parseInt(value) % 3 == 0 || Integer.parseInt(value) % 5 == 0);
            } else {
                Assertions.assertTrue(value.contains("Visual") || value.contains("Nuts"));
            }
        }
    }
}