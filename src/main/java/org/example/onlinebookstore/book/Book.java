package org.example.onlinebookstore.book;


import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name="BOOK")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int bookid;

    @NotBlank(message="Name cannot be empty, gotta have a name")
    private String name;

    private String author;

    private int price;



}
