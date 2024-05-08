package org.example.onlinebookstore.service.impl;

import org.example.onlinebookstore.entity.Book;
import org.example.onlinebookstore.repository.BookRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Iterable<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Book addBook(Book book) {
        return bookRepository.save(book);
    }

    public void deleteBook(Integer id) {
        if(!bookRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            bookRepository.deleteById(id);
        }
    }

    public Book editBook(Book book, Integer id) {
        if (!bookRepository.existsById(id)) {
            return bookRepository.save(book);
        } else {
            bookRepository.deleteById(id);
            return bookRepository.save(book);
        }
    }
}