package org.example.onlinebookstore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.example.onlinebookstore.others.Role;

import java.util.Set;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;

    @NotBlank(message = "name cannot be empty")
    @Column(name = "username", unique = true)
    private String username;

    private Integer age;

    private String address;

    private String password;

    @Enumerated(EnumType.STRING)
    @ElementCollection(targetClass = Role.class, fetch = FetchType.EAGER)
    @CollectionTable(name = "user_roles", joinColumns = @JoinColumn(name = "user_id"))
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "cartid", referencedColumnName = "cartid")
    private Cart cart;


}
