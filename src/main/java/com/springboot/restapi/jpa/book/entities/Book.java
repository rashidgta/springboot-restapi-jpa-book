package com.springboot.restapi.jpa.book.entities;


import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "book_id")
    private int id;

    private String title;

    @OneToOne(cascade = CascadeType.ALL)
    private Author author;
}
