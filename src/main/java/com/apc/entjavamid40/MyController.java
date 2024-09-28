package com.apc.entjavamid40;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import com.apc.entjavamid40.model.UnitLength;
import com.apc.entjavamid40.model.Conversion;
import com.apc.entjavamid40.model.ErrorResponse;
import com.apc.entjavamid40.utility.UnitConverter;

@RestController
@RequestMapping("convert")
public class MyController {

    /*
    * /convert/1/in/cm
    *
    * out put should be found in sample_out.json
    * */
    @CrossOrigin(origins = "*")
    @GetMapping("/{value}/{unit1}/{unit2}/")
    public ResponseEntity<?> convert(@PathVariable String value, @PathVariable String unit1, @PathVariable String unit2) {
        UnitLength from = new UnitLength();
        UnitLength to = new UnitLength();

        try {
            double fromValue = Double.parseDouble(value);
            from.setUnit(unit1);
            from.setValue(fromValue);
            to.setUnit(unit2);
            to.setValue(UnitConverter.convert(fromValue, unit1, unit2));
        } catch (NumberFormatException e) {
            ErrorResponse errorResponse = new ErrorResponse("Invalid value", value, unit1, unit2);
            return ResponseEntity.badRequest().body(errorResponse);
        } catch (IllegalArgumentException e) {
            ErrorResponse errorResponse = new ErrorResponse(e.getMessage(), value, unit1, unit2);
            return ResponseEntity.badRequest().body(errorResponse);
        }

        Conversion conversion = new Conversion(from, to);
        return ResponseEntity.ok(conversion);
        // return ResponseEntity.ok("Hello World");
    }

    List<String> allowedUnits = Arrays.asList("mm","cm","in","m","ft");

}
