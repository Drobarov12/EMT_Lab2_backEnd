package com.example.librarisecond.web.rest;

import com.example.librarisecond.Service.AuthorService;
import com.example.librarisecond.Service.BookService;
import com.example.librarisecond.model.Author;
import com.example.librarisecond.model.Book;
import com.example.librarisecond.model.BookDto;
import com.example.librarisecond.model.Category;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping({"/","/books"})
public class BookRestController {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookRestController(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @GetMapping
    public List<Book> findAll() {
        return this.bookService.findAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id){
        return this.bookService.findById(id)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @GetMapping("/authors")
    public List<Author> findAllAuthors() {
        return this.authorService.listAll();
    }

    @GetMapping("/categories")
    public List<Category> listAll(){
        return List.of(Category.NOVEL,Category.FANTASY,Category.BIOGRAPHI,
                Category.DRAMA,Category.HISTORY,Category.CLASSICS,Category.TRAILER);
    }

    @GetMapping("/add")
    public ResponseEntity<Book> save(@RequestParam BookDto book) {
        return this.bookService.save(book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> edit(@PathVariable Long id, @RequestBody BookDto book) {
        return this.bookService.edit(id, book)
                .map(b -> ResponseEntity.ok().body(b))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PostMapping("/mark-as-taken/{id}")
    public ResponseEntity markAsTaken(@PathVariable Long id) {
        if (this.bookService.findById(id).isPresent())
            if (this.bookService.avalibleCopies(id) > 0){
                this.bookService.markAsTaken(id);
                return ResponseEntity.ok().build();
            }

        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.delete(id);
        if (this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }

}
