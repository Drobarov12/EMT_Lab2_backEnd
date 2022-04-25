package com.example.librarisecond.Service;

import com.example.librarisecond.model.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> listAll();

    Country create(int id,String name,String continent);

    Country edit(Long id,String name,String continent);

    void delete(Long authorId);

    Optional<Country> findByName(String name);

    Optional<Country> findById(Long id);


}
