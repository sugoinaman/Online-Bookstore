package org.example.onlinebookstore.controller;


import org.example.onlinebookstore.repository.CartRepository;
import org.example.onlinebookstore.entity.Book;
import org.example.onlinebookstore.repository.BookRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
@RequestMapping("/api/add-to-cart")
public class CartController {


    private final BookRepository bookRepository;
    private final CartRepository cartRepository;

    public CartController(BookRepository bookRepository, CartRepository cartRepository) {
        this.bookRepository = bookRepository;
        this.cartRepository = cartRepository;
    }

    @PostMapping("")
    public RedirectView addToCart(@RequestParam("bookid") int bookid) {
        addBookToCart(bookid);
        return new RedirectView("/books");
    }

    public void addBookToCart(int bookid) {

        Book book = bookRepository.findById(bookid)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book id" + bookid));
    }
}
