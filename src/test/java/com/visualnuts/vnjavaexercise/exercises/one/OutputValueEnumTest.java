package com.visualnuts.vnjavaexercise.exercises.one;

import com.visualnuts.vnjavaexercise.exercises.one.OutputValueEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputValueEnumTest {

    @Test
    void visualTest() {
        assertEquals("Visual ", OutputValueEnum.getVisualNutsOutput(3));
        assertEquals("Visual ", OutputValueEnum.getVisualNutsOutput(18));
        assertEquals("Visual ", OutputValueEnum.getVisualNutsOutput(27));
    }

    @Test
    void nutsTest() {
        assertEquals("Nuts", OutputValueEnum.getVisualNutsOutput(5));
        assertEquals("Nuts", OutputValueEnum.getVisualNutsOutput(20));
        assertEquals("Nuts", OutputValueEnum.getVisualNutsOutput(50));
    }

    @Test
    void visualNutsTest() {
        assertEquals("Visual Nuts", OutputValueEnum.getVisualNutsOutput(15));
        assertEquals("Visual Nuts", OutputValueEnum.getVisualNutsOutput(30));
        assertEquals("Visual Nuts", OutputValueEnum.getVisualNutsOutput(45));
    }

    @Test
    void integerTest() {
        assertEquals("1", OutputValueEnum.getVisualNutsOutput(1));
        assertEquals("7", OutputValueEnum.getVisualNutsOutput(7));
        assertEquals("46", OutputValueEnum.getVisualNutsOutput(46));
    }
}