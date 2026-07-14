package pja.edu.pl.s30855.tpo_09.services;

import org.springframework.stereotype.Service;
import pja.edu.pl.s30855.tpo_09.models.BMI;

@Service
public class BMIService {
    public BMI calculateBmi(double weight, double height) {
        double bmiValue = weight / Math.pow(height / 100.0, 2);
        int bmiRounded = (int) bmiValue;
        String type;

        if (bmiValue < 18.5) {
            type = "Underweight";
        } else if (bmiValue < 25) {
            type = "Normal";
        } else if (bmiValue < 30) {
            type = "Overweight";
        } else {
            type = "Obese";
        }

        return new BMI(weight, height, bmiRounded, type);
    }

    public String calculateBmiPlain(double weight, double height) {
        double bmiValue = weight / Math.pow(height / 100.0, 2);
        return String.format("%.2f", bmiValue);
    }
}
