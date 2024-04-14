package org.example.onlinebookstore.book;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class DummyDatabaseLoader {

    private final BookRepository repository;


    public DummyDatabaseLoader(BookRepository bookRepository) {
        this.repository = bookRepository;
    }

    @PostConstruct
    private void init() {
        repository.save(new Book(1,"To Kill a Mockingbird", "Harper Lee", 1960));
        repository.save(new Book(2,"1984", "George Orwell", 1949));
        repository.save(new Book(3,"The Great Gatsby", "F. Scott Fitzgerald", 1925));
        repository.save(new Book(4,"One Hundred Years of Solitude", "Gabriel Garcia Marquez", 1967));
        repository.save(new Book(5,"Moby Dick", "Herman Melville", 1851));
        repository.save(new Book(6,"War and Peace", "Leo Tolstoy", 1869));
        repository.save(new Book(7,"Ulysses", "James Joyce", 1922));
        repository.save(new Book(8,"The Odyssey", "Homer", 800));
        repository.save(new Book(9,"Pride and Prejudice", "Jane Austen", 1813));
        repository.save(new Book(10,"The Catcher in the Rye", "J.D. Salinger", 1951));
    }
}
