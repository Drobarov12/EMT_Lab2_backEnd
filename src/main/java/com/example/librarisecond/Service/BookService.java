package com.example.librarisecond.Service;

import com.example.librarisecond.model.Author;
import com.example.librarisecond.model.Book;
import com.example.librarisecond.model.BookDto;
import com.example.librarisecond.model.Category;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> findById(Long id);

    Optional<Book> findByName(String name);

    Optional<Book> save(BookDto bookDto);

    Optional<Book> edit(Long id, BookDto bookDto);

    int avalibleCopies(Long id);

    void markAsTaken(Long id);

    void delete(Long id);
}