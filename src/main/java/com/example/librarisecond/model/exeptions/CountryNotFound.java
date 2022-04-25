package com.example.librarisecond.model.exeptions;

public class CountryNotFound extends RuntimeException{
    public CountryNotFound(Long id) {
        super(String.format("Country with id %d not found",id));
    }
}
