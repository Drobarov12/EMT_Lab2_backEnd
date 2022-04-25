package com.example.librarisecond.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Data
public class BookDto {

    private String name;

    private int avalibaleCopies;

    private Long authorId;

    @Enumerated(value = EnumType.STRING)
    private Category category;

    public BookDto() {
    }

    public BookDto(String name, int avalibaleCopies, Long authorId, Category category) {
        this.name = name;
        this.avalibaleCopies = avalibaleCopies;
        this.authorId = authorId;
        this.category = category;
    }
}
