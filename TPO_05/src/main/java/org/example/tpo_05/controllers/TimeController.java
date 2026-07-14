package org.example.tpo_05.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

@Controller
public class TimeController {

    @GetMapping("/current-time")
    @ResponseBody
    public String getCurrentTime(
            @RequestParam(value = "timezone", defaultValue = "Europe/Warsaw") String timezone,
            @RequestParam(value = "format", defaultValue = "HH:mm:ss.SSSS yyyy/MM/dd") String format) {

        String currentTimeFormatted = "HH:mm:ss.SSSS yyyy/MM/dd";
        String errorMessage = null;

        try {
            ZoneId zoneId = "system".equalsIgnoreCase(timezone) ? ZoneId.systemDefault() : ZoneId.of(timezone);
            ZonedDateTime currentTime = ZonedDateTime.now(zoneId);

            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern(format);
                currentTimeFormatted = currentTime.format(formatter);
            } catch (IllegalArgumentException e) {
                DateTimeFormatter defaultFormatter = DateTimeFormatter.ofPattern("HH:mm:ss.SSSS yyyy/MM/dd");
                errorMessage = "Invalid format. Using default: " + currentTime.format(defaultFormatter);
            }
        } catch (Exception e) {
            ZoneId systemZone = ZoneId.systemDefault();
            ZonedDateTime currentTime = ZonedDateTime.now(systemZone);
            errorMessage = "Invalid time zone provided. Defaulting to system time zone. "
                    + currentTime.format(DateTimeFormatter.ofPattern("HH:mm:ss.SSSS yyyy/MM/dd"));
        }

        return "<!DOCTYPE html>" +
                "<html><head><meta charset='UTF-8'><title>Current Time</title>" +
                "<style>" +
                "body { font-family: sans-serif; background-color: pink; padding: 20px; }" +
                "h1 { text-align: center; color: #c2185b}" +
                ".time, .timezone, .error { text-align: center; margin-top: 10px; }" +
                ".time { font-size: 20px; color: white; }" +
                ".timezone { color: black; }" +
                ".error { color: red; font-weight: bold; }" +
                "</style>" +
                "</head><body>" +
                "<h1>Current Time</h1>" +
                "<div class='time'>" + currentTimeFormatted + "</div>" +
                "<div class='timezone'>Timezone: " + timezone + "</div>" +
                (errorMessage != null ? "<div class='error'>" + errorMessage + "</div>" : "") +
                "</body></html>";
    }

    @GetMapping("/current-year")
    @ResponseBody
    public String getCurrentYear() {
        int year = ZonedDateTime.now().getYear();
        return "<!DOCTYPE html>" +
                "<html><head><meta charset='UTF-8'><title>Current Year</title>" +
                "<style>" +
                "body { font-family: sans-serif; background-color: pink; padding: 20px; }" +
                "h1 { text-align: center; color: black; }" +
                ".year { text-align: center; font-size: 24px; color: black; margin-top: 10px; }" +
                "</style>" +
                "</head><body>" +
                "<h1>Current Year</h1>" +
                "<div class='year'>" + year + "</div>" +
                "</body></html>";
    }
}
