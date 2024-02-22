package org.example.onlinebookstore.user;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.onlinebookstore.cart.Cart;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer userid;

    @NotBlank(message="name cannot be empty")
    private String name;

    private int age;

    private String address;

    @OneToOne
    @JoinColumn(name="cartid",referencedColumnName = "cartid")
    private Cart cart;



}
