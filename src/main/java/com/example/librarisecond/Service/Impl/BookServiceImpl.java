package com.example.librarisecond.Service.Impl;

import com.example.librarisecond.Repository.AuthorRepository;
import com.example.librarisecond.Repository.BookRepository;
import com.example.librarisecond.Service.BookService;
import com.example.librarisecond.model.Author;
import com.example.librarisecond.model.Book;
import com.example.librarisecond.model.BookDto;
import com.example.librarisecond.model.Category;
import com.example.librarisecond.model.exeptions.AuthorNotFound;
import com.example.librarisecond.model.exeptions.BookNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public BookServiceImpl(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
    }

    @Override
    public List<Book> findAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return this.bookRepository.findById(id);
    }

    @Override
    public Optional<Book> findByName(String name) {
        return this.bookRepository.findByName(name);
    }

    @Override
    public Optional<Book> save(BookDto book) {
        Random random = new Random();
        Author a = this.authorRepository.findById(book.getAuthorId()).orElseThrow(()->new AuthorNotFound(book.getAuthorId()));
        int id = random.nextInt(100);
        Book b = new Book(id,book.getName(), book.getAvalibaleCopies(), a, book.getCategory());
        this.bookRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public Optional<Book> edit(Long id, BookDto book) {
        Book b = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFound(id));
        Author a = this.authorRepository.findById(book.getAuthorId()).orElseThrow(()->new AuthorNotFound(book.getAuthorId()));
        b.setName(book.getName());
        b.setAvalibaleCopies(book.getAvalibaleCopies());
        b.setAuthor(a);
        b.setCategory(book.getCategory());
        this.bookRepository.save(b);
        return Optional.of(b);
    }

    @Override
    public int avalibleCopies(Long id) {
        Book b = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFound(id));
        return b.getAvalibaleCopies();
    }

    @Override
    public void markAsTaken(Long id) {
        Book b = this.bookRepository.findById(id).orElseThrow(() -> new BookNotFound(id));
        b.setAvalibaleCopies(b.getAvalibaleCopies() - 1);
    }

    @Override
    public void delete(Long id) {
        this.bookRepository.delete(id);
    }
}
