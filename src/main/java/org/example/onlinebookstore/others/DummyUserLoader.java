package org.example.onlinebookstore.others;

import jakarta.annotation.PostConstruct;
import org.example.onlinebookstore.entity.User;
import org.example.onlinebookstore.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Collections;

@Component
public class DummyUserLoader {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public DummyUserLoader(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void innit() {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword(passwordEncoder.encode("admin"));
        admin.setRoles(Collections.singleton(Role.ADMIN));
        userRepository.save(admin);

        User user = new User();
        user.setUsername("user");
        user.setPassword(passwordEncoder.encode("user"));
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);
    }
}
