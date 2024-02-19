package org.example.onlinebookstore.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

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

    @OneToMany
    @JoinTable(
            name="user_cart",
            joinColumns = @JoinColumn(name="userid"),
            inverseJoinColumns =@JoinColumn(name="bookid")
    )

    private ArrayList<Book> cart;

}
