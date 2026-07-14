package org.example.tpo_05.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class POSTcontroller {
    private static final String DIGITS = "0123456789" +
            "ABCDEFGHIJKLMNOPQRSTUVWXYZ" +
            "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~" +
            "¡¢£¤¥¦§¨©ª«¬®¯°±²³´µ¶·¸¹º»¼½¾¿ØÅ";

    @PostMapping("/convert-base")
    @ResponseBody
    public String convertBase(
            @RequestParam String value,
            @RequestParam int fromBase,
            @RequestParam int toBase) {

        String resultHtml;

        try {
            String validChars = DIGITS.substring(0, fromBase).toUpperCase();

            for (char c : value.toUpperCase().toCharArray()) {
                if (validChars.indexOf(c) == -1) {
                    throw new IllegalArgumentException("Invalid character '" + c + "' for base " + fromBase);
                }
            }

            String normalizedValue = value.toUpperCase();
            long decimalValue = 0;
            for (char c : normalizedValue.toCharArray()) {
                decimalValue = decimalValue * fromBase + DIGITS.indexOf(c);
            }


            StringBuilder converted = new StringBuilder();
            long temp = decimalValue;
            do {
                converted.insert(0, DIGITS.charAt((int) (temp % toBase)));
                temp /= toBase;
            } while (temp > 0);

            resultHtml = "<!DOCTYPE html>" +
                    "<html><head><meta charset='UTF-8'><title>Conversion Result</title>" +
                    "<style>" +
                    "body { background-color: pink; font-family: sans-serif; text-align: center; padding: 40px; }" +
                    ".box { background: white; padding: 20px; border-radius: 8px; display: inline-block; }" +
                    "h1 { color: #c2185b; }" +
                    "p { font-size: 16px; margin: 10px 0; }" +
                    ".label { font-weight: bold; }" +
                    "</style>" +
                    "</head><body>" +
                    "<div class='box'>" +
                    "<h1>Base Conversion</h1>" +
                    "<p><span class='label'>Original:</span> " + value + " (Base " + fromBase + ")</p>" +
                    "<p><span class='label'>Converted:</span> " + converted + " (Base " + toBase + ")</p>" +
                    "<p><span class='label'>Binary:</span> " + Long.toBinaryString(decimalValue) + "</p>" +
                    "<p><span class='label'>Octal:</span> " + Long.toOctalString(decimalValue) + "</p>" +
                    "<p><span class='label'>Decimal:</span> " + decimalValue + "</p>" +
                    "<p><span class='label'>Hex:</span> " + Long.toHexString(decimalValue).toUpperCase() + "</p>" +
                    "</div></body></html>";

        } catch (Exception e) {
            resultHtml = "<!DOCTYPE html><html><head><meta charset='UTF-8'><title>Error</title>" +
                    "<style>body { background-color: #ffeeee; font-family: Arial; padding: 30px; }" +
                    ".container { max-width: 500px; margin: auto; background: white; padding: 20px; border-radius: 8px;" +
                    "box-shadow: 0 4px 8px rgba(0,0,0,0.1); color: red; font-weight: bold; text-align: center; }" +
                    "</style></head><body><div class='container'>" +
                    "Error: " + e.getMessage() + "</div></body></html>";
        }

        return resultHtml;
    }
}
