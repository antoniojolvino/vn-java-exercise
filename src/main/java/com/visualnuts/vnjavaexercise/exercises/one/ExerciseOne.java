package com.visualnuts.vnjavaexercise.exercises.one;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.Optional;

/**
 * Write or describe an algorithm that prints the whole integer numbers to the console, start
 * from the number 1, and print all numbers going up to the number 100.
 * However, when the number is divisible by 3, do not print the number, but print the word
 * 'Visual'. If the number is divisible by 5, do not print the number, but print 'Nuts'. And for all
 * numbers divisible by both (eg: the number 15) the same, but print 'Visual Nuts'.
 * How will you keep this code safe from bugs? Show how you would guarantee that this code
 * keeps working when developers start making small feature adjustments. (Maybe we would
 * want to print the first 500 numbers, ...).
 */
@Service
public class ExerciseOne {

    @Value("${exercise.one.max_value:100}")
    private Integer maxValue;

    private String[] output;

    public void executeAndPrint() {
        Assert.notNull(maxValue, "maxValue is null");

        output = new String[maxValue];

        for (int i = 0; i < maxValue; i++) {
            int currentValue = i + 1;

            Optional.of(i).map(in -> in % 3);

            String outputValue = OutputValueEnum.getVisualNutsOutput(currentValue);

            output[i] = outputValue;
        }

        for (String value : output) {
            System.out.println(value);
        }
    }

    public Integer getMaxValue() {
        return maxValue;
    }

    public String[] getOutput() {
        return output;
    }
}
