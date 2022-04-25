package com.example.librarisecond.Repository;

import com.example.librarisecond.Data.DataHolder;
import com.example.librarisecond.model.Author;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class AuthorRepository{

    public List<Author> listAll(){return DataHolder.authors;    }

    public Author save(Author a){
        if(a==null && a.getName().isEmpty()){
            return null;
        }
        DataHolder.authors.removeIf(i->i.getName().equals(a.getName()));
        DataHolder.authors.add(a);
        return a;
    }

    public Optional<Author> findById(Long id){
        return DataHolder.authors.stream().filter(f->f.getId().equals(id)).findFirst();
    }

    public Optional<Author> findByName(String name){
        return DataHolder.authors.stream().filter(f->f.getName().equals(name)).findFirst();
    }

    public void delete(Long id){
        DataHolder.authors.removeIf(f->f.getId().equals(id));
    }
}
