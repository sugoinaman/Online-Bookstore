package org.example.onlinebookstore.book;

import org.example.onlinebookstore.user.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {
    User findByName(String name);
}
