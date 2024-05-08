package org.example.onlinebookstore.service.impl;

import org.example.onlinebookstore.entity.User;
import org.example.onlinebookstore.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    public void addUser(User user) {
        userRepository.save(user);
    }

    public void deleteUser(Integer id) {
        if(!userRepository.existsById(id)){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        } else {
            userRepository.deleteById(id);
        }
    }

    public User editUser(User user, Integer id) {
        if (!userRepository.existsById(id)) {
            return userRepository.save(user);
        } else {
            userRepository.deleteById(id);
            return userRepository.save(user);
        }
    }
}