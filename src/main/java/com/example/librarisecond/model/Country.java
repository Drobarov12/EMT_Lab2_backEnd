package com.example.librarisecond.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Entity
public class Country {

    @Id
    private Long id;

    private String name;

    private String continent;

    public Country(int id,String name, String continent) {
        this.id = Long.valueOf(id);
        this.name = name;
        this.continent = continent;
    }

    public Country() {
    }
}
