package pja.edu.pl.s30855.tpo_09.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pja.edu.pl.s30855.tpo_09.models.BMI;
import pja.edu.pl.s30855.tpo_09.services.BMIService;

@Controller
public class BMIController {

    private BMIService service;

    public BMIController (BMIService service){
        this.service = service;
    }

    @GetMapping(path = "/api/v1/BMI", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BMI> getBmiJson(@RequestParam double weight,
                                                  @RequestParam double height) {
        if (weight <= 0 || height <= 0) {
            return ResponseEntity.badRequest().header("reason", "invalid data, weight and height parameters must be positive numbers").build();
        }

        return ResponseEntity.ok(service.calculateBmi(weight, height));
    }

    @GetMapping(path = "/api/v1/BMI", produces = "application/xml")
    @ResponseBody
    public ResponseEntity<BMI> getBmiXml(@RequestParam double weight,
                                                 @RequestParam double height) {
        if (weight <= 0 || height <= 0) {
            return ResponseEntity.badRequest().header("reason", "invalid data, weight and height parameters must be positive numbers").build();
        }

        return ResponseEntity.ok(service.calculateBmi(weight, height));
    }

    @GetMapping(path = "/api/v1/BMI", produces = "text/plain")
    @ResponseBody
    public ResponseEntity<String> getBmiPlain(@RequestParam double weight,
                                              @RequestParam double height) {
        if (weight <= 0 || height <= 0) {
            return ResponseEntity.badRequest().header("reason", "invalid data, weight and height parameters must be positive numbers").build();
        }
        return ResponseEntity.ok(service.calculateBmiPlain(weight, height));
    }

}
