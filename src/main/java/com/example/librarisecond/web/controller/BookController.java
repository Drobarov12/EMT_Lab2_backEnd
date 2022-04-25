package com.example.librarisecond.web.controller;

import com.example.librarisecond.Service.BookService;
import com.example.librarisecond.model.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/normalBookController")
public class BookController {
    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public String getBookPage(Model model){
        List<Book> books = this.bookService.findAll();

        model.addAttribute("books",books);
        return "BooksPage";
    }
}
