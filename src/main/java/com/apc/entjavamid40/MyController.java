package com.apc.entjavamid40;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("convert")
public class MyController {

    UnitConverter converter = new UnitConverter();  // Create an instance of UnitConverter

    /*
     * Example: /convert/1/in/cm
     */
    @GetMapping("/{value}/{unit1}/{unit2}/")
    public Map<String, Object> convert(@PathVariable double value,
                                       @PathVariable String unit1,
                                       @PathVariable String unit2) {
        // Use the UnitConverter class for conversion logic
        return converter.convertUnits(value, unit1, unit2);
    }
}