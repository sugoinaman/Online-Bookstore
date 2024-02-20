package org.example.onlinebookstore.entities.repositories;

import org.example.onlinebookstore.entities.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
}
