package pja.edu.pl.s30855.tpo_07.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pja.edu.pl.s30855.tpo_07.models.StoredCode;
import org.springframework.ui.Model;
import pja.edu.pl.s30855.tpo_07.models.StoredCodeRepository;
import pja.edu.pl.s30855.tpo_07.services.CodeFormatterService;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public class FormatterController {

    private CodeFormatterService formatterService;
    private StoredCodeRepository storedCodeRepository;

    public FormatterController(CodeFormatterService formatterService, StoredCodeRepository storedCodeRepository) {
        this.formatterService = formatterService;
        this.storedCodeRepository = storedCodeRepository;

        Thread cleaner = new Thread(() -> {
            while (true) {
                try {
                    storedCodeRepository.cleanUp();
                    Thread.sleep(10_000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        });
        cleaner.start();
    }

    @GetMapping("/")
    public String index(Model model){
        storedCodeRepository.cleanUp();
        return "mainPage";
    }

    @GetMapping("/find")
    public String find(@RequestParam("id") String id, Model model){
        List<StoredCode> foundCodes = storedCodeRepository.find(id);
        if(!foundCodes.isEmpty()){
            String foundOriginalCode = foundCodes.getFirst().getOriginal();
            String foundFormattedCode = foundCodes.getLast().getFormatted();
            model.addAttribute("foundOldCode", foundOriginalCode);
            model.addAttribute("foundNewCode", foundFormattedCode);
        }else {
            model.addAttribute("message", "There is no code in storage with this id");
        }
        return "resultPage";
    }


    @PostMapping("/format")
    public String formatCode(
            @RequestParam("id") String id,
            @RequestParam("code") String code,
            @RequestParam ("time") int time,
            Model model
    ){
        try {
            storedCodeRepository.cleanUp();
            String formatted = formatterService.format(code);
            storedCodeRepository.save(new StoredCode(id, code, formatted, LocalDateTime.now().plusSeconds(time)));
            model.addAttribute("original", code);
            model.addAttribute("formatted", formatted);
            model.addAttribute("id", id);
            model.addAttribute("time", time);

            return "resultPage";
        } catch (Exception e) {
            model.addAttribute("error", e.getMessage());
            return "error";
        }
    }
}
