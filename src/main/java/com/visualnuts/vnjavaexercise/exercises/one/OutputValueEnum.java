package com.visualnuts.vnjavaexercise.exercises.one;

import java.util.function.Function;

public enum OutputValueEnum {
    VISUAL(i -> (int) i % 3 == 0 ? "Visual " : ""),
    NUTS(i -> (int) i % 5 == 0 ? "Nuts" : "")
    ;

    private final Function<Integer, String> functionOutput;

    OutputValueEnum(Function<Integer, String> functionOutput) {
        this.functionOutput = functionOutput;
    }

    public String getOutputFromInteger(Integer i) {
        return functionOutput.apply(i);
    }

    public static String getVisualNutsOutput(int currentValue) {
        String outputValue = VISUAL.getOutputFromInteger(currentValue);
        outputValue += NUTS.getOutputFromInteger(currentValue);
        outputValue = outputValue.isBlank() ? String.valueOf(currentValue) : outputValue;
        return outputValue;
    }
}
