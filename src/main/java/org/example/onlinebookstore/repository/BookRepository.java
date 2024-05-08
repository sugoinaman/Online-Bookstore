package org.example.onlinebookstore.repository;

import org.example.onlinebookstore.entity.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

}
