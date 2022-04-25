package com.example.librarisecond.model.exeptions;

public class AuthorNotFound extends RuntimeException{
    public AuthorNotFound(Long id) {
        super(String.format("Author with id %d not found",id));
    }
}
