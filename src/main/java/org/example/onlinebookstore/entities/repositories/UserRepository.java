package org.example.onlinebookstore.entities.repositories;

import org.example.onlinebookstore.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer> {
    User findByName(String name);
}
