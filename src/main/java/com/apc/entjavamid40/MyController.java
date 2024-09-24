package com.apc.entjavamid40;


import com.apc.entjavamid40.builder.JSONBuilder;
import com.apc.entjavamid40.service.UnitConversionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("convert")
public class MyController {

    @Autowired
    private UnitConversionService conversionService;

    @Autowired
    private JSONBuilder jsonBuilder;

    /*
    * /convert/1/in/cm
    *
    * out put should be found in sample_out.json
    * */

    List<String> allowedUnits = Arrays.asList("mm","cm","in","m","ft");

    @GetMapping("/{value}/{unit1}/{unit2}")
    public Map<String, Object> convert(@PathVariable double value,
                                       @PathVariable String unit1,
                                       @PathVariable String unit2) {
        if (!allowedUnits.contains(unit1) || !allowedUnits.contains(unit2)) {
            throw new IllegalArgumentException("Invalid unit. Allowed units are: " + allowedUnits);
        }

        double convertedValue = conversionService.convert(unit1, unit2, value);
        return jsonBuilder.buildResponse(unit1, value, unit2, convertedValue);
    }

}
