package org.example.onlinebookstore.controller;

import lombok.RequiredArgsConstructor;
import org.example.onlinebookstore.repository.BookRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class HomeController {

    private final BookRepository bookRepository;

    @GetMapping
    public String home(Model model) {
        model.addAttribute("book", bookRepository.findAll());
        return "Book";
    }
}
