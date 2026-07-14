package pja.edu.pl.s30855.tpo12.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pja.edu.pl.s30855.tpo12.auth.PublisherRegistrationDTO;
import pja.edu.pl.s30855.tpo12.auth.ReaderRegistrationDTO;
import pja.edu.pl.s30855.tpo12.repositories.BookRepository;
import pja.edu.pl.s30855.tpo12.services.UserService;

@Controller
public class HomePageController {
    private final BookRepository bookRepository;
    private final UserService userService;

    public HomePageController(BookRepository bookRepository, UserService userService) {
        this.bookRepository = bookRepository;
        this.userService = userService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("books", bookRepository.findAll());
        return "home";
    }


    @GetMapping("/registered")
    public String registrationSuccess() {
        return "registered";
    }

    @GetMapping("/publisher-dashboard")
    public String publisherDashboard() {
        return "publisher-dashboard";
    }


    @GetMapping("/register/reader")
    public String showReaderRegistrationForm(Model model) {
        model.addAttribute("userDto", new ReaderRegistrationDTO());
        return "register-reader";
    }

    @GetMapping("/register/publisher")
    public String showPublisherRegistrationForm(Model model) {
        model.addAttribute("userDto", new PublisherRegistrationDTO());
        return "register-publisher";
    }

    @PostMapping("/register/reader")
    public String registerReader(@ModelAttribute("userDto")  ReaderRegistrationDTO userDto,
                                 BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register-reader";
        }

        try {
            userService.registerReader(userDto);
        } catch (IllegalArgumentException e) {
            model.addAttribute("registrationError", e.getMessage());
            return "register-reader";
        }

        return "redirect:/registered";
    }

    @PostMapping("/register/publisher")
    public String registerPublisher(@ModelAttribute("userDto") PublisherRegistrationDTO userDto,
                                    BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "register-publisher";
        }

        try {
            userService.registerPublisher(userDto);
        } catch (IllegalArgumentException e) {
            model.addAttribute("registrationError", e.getMessage());
            return "register-publisher";
        }

        return "registered";
    }

    @GetMapping("/search")
    public String searchBooks(@RequestParam String keyword, Model model) {
        model.addAttribute("books", bookRepository.findByTitleContainingIgnoreCase(keyword));
        return "home";
    }

}
