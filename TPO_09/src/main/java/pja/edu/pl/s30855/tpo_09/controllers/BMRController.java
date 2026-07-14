package pja.edu.pl.s30855.tpo_09.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pja.edu.pl.s30855.tpo_09.models.BMR;
import pja.edu.pl.s30855.tpo_09.services.BMRService;

@Controller
public class BMRController {

    private BMRService service;

    public BMRController(BMRService service){
        this.service = service;
    }

    @GetMapping(path = "/api/v1/BMR", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<BMR> getBmrJson(@RequestParam String gender, @RequestParam double weight,
                                          @RequestParam double height, @RequestParam int age) {
        if (!gender.equalsIgnoreCase("man") && !gender.equalsIgnoreCase("woman")) {
            return ResponseEntity.badRequest().header("reason", "invalid gender data").build();
        }

        if (weight <= 0 || height <= 0 || age <= 0) {
            return ResponseEntity.status(499).header("reason", "invalid data, weight and height, and age  parameters must be positive numbers").build();
        }

        return ResponseEntity.ok(service.calculateBmr(gender, weight, height,age));
    }

    @GetMapping(path = "/api/v1/BMR", produces = MediaType.APPLICATION_XML_VALUE)
    @ResponseBody
    public ResponseEntity<BMR> getBmrXml(@RequestParam String gender, @RequestParam double weight,
                                         @RequestParam double height, @RequestParam int age) {
        if (!gender.equalsIgnoreCase("man") && !gender.equalsIgnoreCase("woman")) {
            return ResponseEntity.badRequest().header("reason", "invalid gender data").build();
        }

        if (weight <= 0 || height <= 0 || age <=0) {
            return ResponseEntity.status(499).header("reason", "invalid data, weight and height, and age  parameters must be positive numbers").build();
        }

        return ResponseEntity.ok(service.calculateBmr(gender,weight, height, age));
    }

    @GetMapping(path = "/api/v1/BMR", produces = "text/plain")
    @ResponseBody
    public ResponseEntity<String> getBmrPlain(@RequestParam String gender, @RequestParam double weight,
                                              @RequestParam double height, @RequestParam int age) {
        if (!gender.equalsIgnoreCase("man") && !gender.equalsIgnoreCase("woman")) {
            return ResponseEntity.badRequest().header("reason", "invalid gender data").build();
        }

        if (weight <= 0 || height <= 0 || age <= 0) {
            return ResponseEntity.status(499).header("reason", "invalid data, weight and height, and age parameters must be positive numbers").build();
        }
        return ResponseEntity.ok(service.calculateBmrPlain(gender, weight, height, age));
    }
}
