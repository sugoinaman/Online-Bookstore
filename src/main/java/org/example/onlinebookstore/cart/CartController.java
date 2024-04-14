package org.example.onlinebookstore.cart;


import org.example.onlinebookstore.book.Book;
import org.example.onlinebookstore.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;
import java.util.Arrays;

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
