package com.example.librarisecond.Data;

import com.example.librarisecond.model.Author;
import com.example.librarisecond.model.Book;
import com.example.librarisecond.model.Category;
import com.example.librarisecond.model.Country;
import lombok.Getter;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
@Getter
public class DataHolder {

    public static List<Country> countries = new ArrayList<>();
    public static List<Author> authors = new ArrayList<>();
    public static List<Book> books = new ArrayList<>();

    @PostConstruct
    public void init(){
        countries.add(new Country(1,"Macedonia","Europe"));
        countries.add(new Country(2,"Tasmania","Australia"));
        countries.add(new Country(3,"Egypt","Africa"));
        countries.add(new Country(4,"Brazil","South America"));
        countries.add(new Country(5,"Nevada","North America"));
        countries.add(new Country(6,"Russia","Asia"));

        authors.add(new Author( 1,"Marcel","Proust", countries.get(0)));
        authors.add(new Author( 2,"James","Joyce", countries.get(1)));
        authors.add(new Author(3,"Miguel de","Cervantes", countries.get(2)));
        authors.add(new Author( 4,"Herman","Melville", countries.get(3)));
        authors.add(new Author( 5,"Leo","Tolstoy", countries.get(4)));
        authors.add(new Author( 6,"William","Shakespeare", countries.get(5)));

        books.add(new Book(1,"Hamlet",5, authors.get(5), Category.DRAMA));
        books.add(new Book(2,"War and Peace",2, authors.get(4), Category.HISTORY));
        books.add(new Book(3,"Moby Dick",10, authors.get(3), Category.FANTASY));
        books.add(new Book(4,"Don Quixote",20, authors.get(2), Category.FANTASY));
        books.add(new Book(5,"Ulysses",5, authors.get(1), Category.NOVEL));
        books.add(new Book(6,"In Search of Lost Time",3, authors.get(0), Category.BIOGRAPHI));

    }
}