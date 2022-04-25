package com.example.librarisecond.Service;

import com.example.librarisecond.model.Author;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> listAll();

    Author create(int id,String name,String surname,Long countryId);

    Author edit(Long id,String name,String surname,Long countryId);

    void delete(Long authorId);

    Optional<Author> findByName(String name);

    Optional<Author> findById(Long id);
}

