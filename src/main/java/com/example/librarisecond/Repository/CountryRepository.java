package com.example.librarisecond.Repository;

import com.example.librarisecond.Data.DataHolder;
import com.example.librarisecond.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CountryRepository {


    public List<Country> findAll(){return DataHolder.countries;}

    public Optional<Country> findAllById(Long id){
        return DataHolder.countries.stream()
                .filter(f->f.getId().equals(id)).findFirst();
    }

    public Optional<Country> findByName(String name) {
        return DataHolder.countries.stream().filter(r->r.getName().equals(name)).findFirst();
    }

    public Country save(Country c){
        if (c==null || c.getName().isEmpty()) {
            return null;
        }
        DataHolder.countries.removeIf(r->r.getName().equals(c.getName()));
        DataHolder.countries.add(c);
        return c;
    }

    public void delete(Long id) {
        DataHolder.countries.removeIf(r->r.getId().equals(id));
    }

}
