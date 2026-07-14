package pja.edu.s30855.tpo_06.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pja.edu.s30855.tpo_06.models.FakeDataService;
import pja.edu.s30855.tpo_06.models.Languages;
import pja.edu.s30855.tpo_06.models.PersonDTO;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Controller
public class DataController {

    private final FakeDataService fakeDataService;

    private final List<String> supportedLanguages = List.of("en", "fr", "de", "es", "it", "pt", "nl", "pl", "uk", "ru");

    public DataController(FakeDataService fakeDataService){
        this.fakeDataService = fakeDataService;
    }

    @GetMapping("/")
    public String showFor(Model model) {
        model.addAttribute("languages", supportedLanguages);
        return "index";
    }

    @PostMapping("/generate")
    public String generateData(
            @RequestParam int count,
            @RequestParam String language,
            @RequestParam(required = false) Set<String> fields,
            Model model
    ) {
        if (count <= 0) {
            model.addAttribute("error", "Number of entries must be greater than zero.");
            return "index";
        }

        if(fields == null){
            fields = new HashSet<>();
        }
        List<PersonDTO> people = fakeDataService.generateFakePeople(count, language, fields);
        model.addAttribute("people", people);
        model.addAttribute("fields", fields);
        model.addAttribute("language", language);
        model.addAttribute("languages", supportedLanguages);
        Map<String, String> labels = Languages.getFieldLabels(language);
        model.addAttribute("labels", labels);

        return "index";
    }
}
