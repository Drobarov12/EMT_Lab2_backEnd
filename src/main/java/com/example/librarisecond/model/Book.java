package com.example.librarisecond.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Book {

    @Id
    private Long id;

    private String name;

    private int avalibaleCopies;

    @ManyToOne
    private Author author;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    public Book(int id,String name, int avalibaleCopies, Author author, Category category) {
        this.id = Long.valueOf(id);
        this.name = name;
        this.avalibaleCopies = avalibaleCopies;
        this.author = author;
        this.category = category;
    }

    public Book() {
    }
}
