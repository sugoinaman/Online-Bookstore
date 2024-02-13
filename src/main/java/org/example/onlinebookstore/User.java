package org.example.onlinebookstore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    //@NotBlank(message="name cannot be empty")
    private String name;

   // @NotBlank(message= "email cannot be empty")
    private String email;

    //@NotBlank(message="phone cannot be empty")
    private Integer phone;

    private Integer urmumgae;
}
