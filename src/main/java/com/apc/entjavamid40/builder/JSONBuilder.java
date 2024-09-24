package com.apc.entjavamid40.builder;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class JSONBuilder {

    public Map<String, Object> buildResponse(String unit1, double value, String unit2, double convertedValue) {
        Map<String, Object> from = new HashMap<>();
        from.put("unit", unit1);
        from.put("length", value);

        Map<String, Object> to = new HashMap<>();
        to.put("unit", unit2);
        to.put("length", convertedValue);

        Map<String, Object> response = new HashMap<>();
        response.put("from", from);
        response.put("to", to);

        return response;
    }

}
