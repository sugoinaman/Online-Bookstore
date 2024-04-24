package org.example.onlinebookstore.book;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;


@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{id}")
    public Book get(@PathVariable Integer id) {

        return bookRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping()
    public void create(@RequestBody Book book) {
        bookRepository.save(book);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PutMapping("/{id}")
    public void update(@RequestBody Book book, @PathVariable Integer id) {
        if (!bookRepository.existsById(id)) {
            System.out.println("Book not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bookRepository.deleteById(id);
        bookRepository.save(book);

    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Integer id) {
        if (!bookRepository.existsById(id)) {
            System.out.println("Book not found");
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        bookRepository.deleteById(id);

    }
}
//TODO: add pagination
