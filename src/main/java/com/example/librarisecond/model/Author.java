package com.example.librarisecond.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Author{

    @Id
    private Long id;

    private String name;

    private String surname;

    @ManyToOne
    private Country contry;

    public Author(int id,String name, String surname, Country contry) {
        this.id = Long.valueOf(id);
        this.name = name;
        this.surname = surname;
        this.contry = contry;
    }

    public Author() {

    }
}
