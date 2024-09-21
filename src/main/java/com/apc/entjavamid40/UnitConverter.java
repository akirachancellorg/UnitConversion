package com.apc.entjavamid40;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UnitConverter {

    // Allowed units for conversion
    private final List<String> allowedUnits = Arrays.asList("mm", "cm", "in", "m", "ft");

    // Conversion factors to meters (base unit)
    private final Map<String, Double> toMeters = new HashMap<String, Double>() {{
        put("mm", 0.001);
        put("cm", 0.01);
        put("in", 0.0254);
        put("m", 1.0);
        put("ft", 0.3048);
    }};

    // Main conversion method
    public Map<String, Object> convertUnits(double value, String unit1, String unit2) {
        Map<String, Object> response = new HashMap<>();

        // Validate units
        if (!allowedUnits.contains(unit1) || !allowedUnits.contains(unit2)) {
            response.put("error", "Invalid units. Allowed units are " + allowedUnits.toString());
            return response;
        }

        // Convert value to meters first (base unit)
        double valueInMeters = value * toMeters.get(unit1);

        // Convert meters to the target unit
        double convertedValue = valueInMeters / toMeters.get(unit2);

        // Prepare response
        response.put("original_value", value);
        response.put("original_unit", unit1);
        response.put("converted_value", convertedValue);
        response.put("converted_unit", unit2);

        return response;
    }
}
