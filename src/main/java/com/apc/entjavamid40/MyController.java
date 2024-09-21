package com.apc.entjavamid40;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("convert")
public class MyController {

    private static final List<String> ALLOWED_UNITS = List.of("mm", "cm", "in", "m", "ft");
    private static final Map<String, Double> CONVERSION_FACTORS = Map.of(
            "inToCm", 2.54,
            "cmToIn", 1 / 2.54
    );

    @GetMapping("/{fromUnit}/{toUnit}/{value}")
    public Map<String, Object> convert(
            @PathVariable String fromUnit,
            @PathVariable String toUnit,
            @PathVariable double value) {

        if (!ALLOWED_UNITS.contains(fromUnit) || !ALLOWED_UNITS.contains(toUnit)) {
            throw new IllegalArgumentException("Unsupported units for conversion.");
        }

        double convertedValue = convertValue(fromUnit, toUnit, value);

        return createResponse(fromUnit, value, toUnit, convertedValue);
    }

    private double convertValue(String fromUnit, String toUnit, double value) {
        if (fromUnit.equals("in") && toUnit.equals("cm")) {
            return value * CONVERSION_FACTORS.get("inToCm");
        } else if (fromUnit.equals("cm") && toUnit.equals("in")) {
            return value * CONVERSION_FACTORS.get("cmToIn");
        }
        throw new IllegalArgumentException("Conversion not implemented for these units.");
    }

    private Map<String, Object> createResponse(String fromUnit, double fromValue, String toUnit, double toValue) {
        Map<String, Object> response = new HashMap<>();

        Map<String, Object> fromMap = new HashMap<>();
        fromMap.put("unit", fromUnit);
        fromMap.put("length", fromValue);

        Map<String, Object> toMap = new HashMap<>();
        toMap.put("unit", toUnit);
        toMap.put("length", toValue);

        response.put("from", fromMap);
        response.put("to", toMap);

        return response;
    }
}