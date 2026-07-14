package pja.edu.pl.s30855.tpo12.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pja.edu.pl.s30855.tpo12.auth.Book;

import pja.edu.pl.s30855.tpo12.repositories.BookRepository;


@Controller
@RequestMapping("/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @GetMapping("/add")
    public String addBookForm(Model model) {
        model.addAttribute("book", new Book());
        return "book-form";
    }

    @PostMapping("/add")
    public String saveBook(@ModelAttribute Book book) {
        bookRepository.save(book);
        return "redirect:/";
    }

}
