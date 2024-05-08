package org.example.onlinebookstore.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

@Table(name = "BOOK")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {

    @Id
   // @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer bookid;

    @NotBlank(message = "Name cannot be empty")
    private String name;

    private String author;

    private Integer price;
}
