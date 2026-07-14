package pja.edu.pl.s30855.tpo_09.services;

import org.springframework.stereotype.Service;
import pja.edu.pl.s30855.tpo_09.models.BMR;

@Service
public class BMRService {
    public BMR calculateBmr(String gender, double weight, double height, int age) {
        int bmr;

        if (gender.equalsIgnoreCase("man")) {
            bmr = (int) (88.362 + 13.397 * weight + 4.799 * height - 5.677 * age);
        } else {
            bmr = (int) (447.593 + 9.247 * weight + 3.098 * height - 4.330 * age);
        }

        return new BMR(gender.toLowerCase(), weight, height, age, bmr);
    }

    public String calculateBmrPlain(String gender, double weight, double height, int age) {
        int bmr;

        if (gender.equalsIgnoreCase("man")) {
            bmr = (int) (88.362 + 13.397 * weight + 4.799 * height - 5.677 * age);
        } else {
            bmr = (int) (447.593 + 9.247 * weight + 3.098 * height - 4.330 * age);
        }

        return bmr + " kcal";
    }
}
