package org.example.onlinebookstore.controller;

import org.example.onlinebookstore.repository.BookRepository;
import org.example.onlinebookstore.repository.UserRepository;


public class UserController {


    private final UserRepository userRepository;
    private final BookRepository bookRepository;

    public UserController(UserRepository userRepository, BookRepository bookRepository) {
        this.userRepository = userRepository;
        this.bookRepository=bookRepository;
    }

}
