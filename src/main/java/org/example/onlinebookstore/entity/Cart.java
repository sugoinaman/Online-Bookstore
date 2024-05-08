package org.example.onlinebookstore.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    private Integer cartid;

    private Integer totalPrice;

    //for the user table
    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    @OneToMany
    @JoinTable(
            name = "cart_books",
            joinColumns = @JoinColumn(name = "cartid"),
            inverseJoinColumns = @JoinColumn(name = "bookid")
    )
    private ArrayList<Book> books;

}
