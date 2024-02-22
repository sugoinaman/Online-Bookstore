package org.example.onlinebookstore.cart;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.example.onlinebookstore.book.Book;
import org.example.onlinebookstore.user.User;

import java.util.ArrayList;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart {

    @Id
    private int cartid;

    private int totalPrice;


    //for the user table
    @OneToOne
    @JoinColumn(name = "userid", referencedColumnName = "userid")
    private User user;

    /*
    for the books table
    since a book will be in many carts we need to use a
    join table, if for example we have
    an article and comments. one article may have many comments but
    one comment is only for that article, in that case we wont need
    a join table

     */

    @OneToMany
    @JoinTable(
            name = "cart_books",
            joinColumns = @JoinColumn(name = "cartid"),
            inverseJoinColumns = @JoinColumn(name = "bookid")
    )
    private ArrayList<Book> books;



}
