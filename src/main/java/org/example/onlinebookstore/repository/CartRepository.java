package org.example.onlinebookstore.repository;

import org.example.onlinebookstore.entity.Cart;
import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart,Integer> {

}
