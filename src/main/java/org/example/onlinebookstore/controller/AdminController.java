package org.example.onlinebookstore.controller;

import org.example.onlinebookstore.constants.PathConstants;
import org.example.onlinebookstore.entity.Book;
import org.example.onlinebookstore.entity.User;
import org.example.onlinebookstore.others.Role;
import org.example.onlinebookstore.service.impl.BookService;
import org.example.onlinebookstore.service.impl.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@Controller
@PreAuthorize("hasAuthority('ADMIN')")
@RequestMapping(PathConstants.admin)

public class AdminController {

    private final BookService bookService;
    private final UserService userService;


    public AdminController(BookService bookService, UserService userService) {
        this.bookService = bookService;
        this.userService = userService;
    }

    @GetMapping("/get/books")
    public String getBooks(Model model) {
        model.addAttribute("books", bookService.getAllBooks());
        return "admin-get-books";
    }

    @GetMapping("/add/books")
    public String addBooks(Model model) {
        model.addAttribute("book", new Book());
        return "admin-add-books";
    }

    @PostMapping("/add/books")
    public String addBooks(@ModelAttribute Book book) {
        bookService.addBook(book);
        return "redirect:/admin/get/books";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete-books/{id}")
    public String deleteBooks(@PathVariable Integer id) {
        bookService.deleteBook(id);
        return "";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/edit-books/{id}")
    public String editBooks(@RequestBody Book book, @PathVariable Integer id) {
        bookService.editBook(book, id);
        return "";
    }

    /*
     *this section is for the controls an admin has on user
     */
    @GetMapping("/get/users")
    public String getUser(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "admin-get-users";
    }

    @GetMapping("/add/users")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("allRoles", Arrays.asList(Role.values()));
        return "admin-add-users";
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/add-users")
    public String addUser(@RequestBody User user) {
        userService.addUser(user);
        return "redirect:/admin/get/users";
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/delete-user{id}")
    public String deleteUser(@PathVariable Integer id) {
        userService.deleteUser(id);
        return "success";
    }
}

//An admin can view, add "books-user", edit, delete,