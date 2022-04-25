package com.example.librarisecond.Repository;

import com.example.librarisecond.Data.DataHolder;
import com.example.librarisecond.model.Book;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BookRepository {
    public List<Book> findAll(){return DataHolder.books;}

    public Book save(Book b){

        if(b==null || b.getName().isEmpty())
            return null;

//        DataHolder.books.removeIf(f->f.getName().equals(b.getName()));
        DataHolder.books.add(b);
        return b;

    }

    public Optional<Book> findByName(String name){
        return DataHolder.books.stream().filter(f->f.getName().equals(name)).findFirst();
    }

    public Optional<Book> findById(Long id){
        return DataHolder.books.stream().filter(f->f.getId().equals(id)).findFirst();
    }



    public void delete(Long id){
        DataHolder.books.removeIf(f->f.getId().equals(id));
    }
}
