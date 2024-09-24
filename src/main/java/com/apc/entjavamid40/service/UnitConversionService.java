package com.apc.entjavamid40.service;

import org.springframework.stereotype.Service;

@Service
public class UnitConversionService {

    //Convert Cases
    public double convert(String unit1, String unit2, double value) {
        return switch (unit1) {
            case "mm" -> fromMm(unit2, value);
            case "cm" -> fromCm(unit2, value);
            case "in" -> fromIn(unit2, value);
            case "m" -> fromM(unit2, value);
            case "ft" -> fromFt(unit2, value);
            default -> throw new IllegalArgumentException(unit2 + " is not supported:");
        };
    }
    //Unit 1 Conversion Cases
    private double fromCm(String unit2, double value) {
        return switch (unit2) {
            case "mm" -> value * 10;
            case "in" -> value * 0.393701;
            case "m" -> value / 100;
            case "ft" -> value * 0.0328084;
            default -> throw new IllegalArgumentException(unit2 + " is not supported:");
        };
    }
    private double fromIn(String unit2, double value) {
        return switch (unit2) {
            case "mm" -> value * 25.4;
            case "cm" -> value * 2.54;
            case "m" -> value * 0.0254;
            case "ft" -> value / 12;
            default -> throw new IllegalArgumentException(unit2 + " is not supported:");
        };
    }
    private double fromM(String unit2, double value) {
        return switch (unit2) {
            case "mm" -> value * 1000;
            case "cm" -> value * 100;
            case "in" -> value * 39.3701;
            case "ft" -> value * 3.28084;
            default -> throw new IllegalArgumentException(unit2 + " is not supported:");
        };
    }
    private double fromFt(String unit2, double value) {
        return switch (unit2) {
            case "mm" -> value * 304.8;
            case "cm" -> value * 30.48;
            case "in" -> value * 12;
            case "m" -> value * 0.3048;
            default -> throw new IllegalArgumentException(unit2 + " is not supported:");
        };
    }
    private double fromMm(String unit2, double value) {
        return switch (unit2) {
            case "cm" -> value / 10;
            case "in" -> value * 0.0393701;
            case "m" -> value / 1000;
            case "ft" -> value * 0.00328084;
            default -> throw new IllegalArgumentException(unit2 + " is not supported:");
        };
    }
}
