package com.apc.entjavamid40;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.apc.entjavamid40.utility.UnitConverter;

@SpringBootTest
class Entjavamid40ApplicationTests {

    @Test
    void contextLoads() {
    }
    
    @Test
    void testConvertInchesToCentimeters() {
        double result = UnitConverter.convert(1, "in", "cm");
        assertEquals(2.54, result, 0.001);
    }

    @Test
    void testConvertCentimetersToInches() {
        double result = UnitConverter.convert(2.54, "cm", "in");
        assertEquals(1, result, 0.001);
    }

    @Test
    void testConvertInvalidUnit() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            UnitConverter.convert(1, "invalid", "cm");
        });
        assertEquals("Invalid unit", exception.getMessage());
    }

    @Test
    void testConvertSameUnit() {
        double result = UnitConverter.convert(1, "cm", "cm");
        assertEquals(1, result, 0.001);
    }

    @Test
    void testConvertZeroValue() {
        double result = UnitConverter.convert(0, "in", "cm");
        assertEquals(0, result, 0.001);
    }
}
