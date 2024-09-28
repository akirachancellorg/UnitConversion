package com.apc.entjavamid40.utility;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;

public class UnitConverter {
    
    private static final Map<String, Double> conversionMap = new HashMap<String, Double>() {
        {
            put("mm", 1.0);
            put("cm", 10.0);
            put("in", 25.4);
            put("m", 1000.0);
            put("ft", 304.8);
        }
    };

    private static final List<String> allowedUnits = Arrays.asList("mm", "cm", "in", "m", "ft");

    public static double convert(double value, String unit1, String unit2) {
        if (!isValidUnit(unit1) || !isValidUnit(unit2)) {
            throw new IllegalArgumentException("Invalid unit");
        }
        double valueInMeters = value * conversionMap.get(unit1);
        double convertedValue = valueInMeters / conversionMap.get(unit2);
        return convertedValue;
    }

    public static boolean isValidUnit(String unit) {
        return allowedUnits.contains(unit);
    }

}