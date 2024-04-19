package org.example.onlinebookstore.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.onlinebookstore.cart.Cart;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;

    @NotBlank(message = "name cannot be empty")
    private String name;

    private Integer age;

    private String address;

    @Enumerated(EnumType.STRING)
    @ElementCollection
    private Set<Role> roles;

    @OneToOne
    @JoinColumn(name = "cartid", referencedColumnName = "cartid")
    private Cart cart;

}
