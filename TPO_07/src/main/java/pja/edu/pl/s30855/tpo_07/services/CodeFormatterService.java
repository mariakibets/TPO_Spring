package pja.edu.pl.s30855.tpo_07.services;

import org.springframework.stereotype.Service;
import com.google.googlejavaformat.java.Formatter;
import com.google.googlejavaformat.java.FormatterException;

@Service
public class CodeFormatterService {
    public String format(String input) throws FormatterException {
        try {
            Formatter formatter = new Formatter();
            return formatter.formatSource(input);
        } catch (FormatterException e) {
            System.err.println("Formatting failed: " + e.getMessage());
            throw e;
        }
    }
}
