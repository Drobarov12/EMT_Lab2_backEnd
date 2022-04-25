package com.example.librarisecond.Service.Impl;

import com.example.librarisecond.Repository.AuthorRepository;
import com.example.librarisecond.Repository.CountryRepository;
import com.example.librarisecond.Service.AuthorService;
import com.example.librarisecond.model.Author;
import com.example.librarisecond.model.Country;
import com.example.librarisecond.model.exeptions.AuthorNotFound;
import com.example.librarisecond.model.exeptions.CountryNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
    }


    @Override
    public List<Author> listAll() {
        return this.authorRepository.listAll();
    }

    @Override
    public Author create(int id,String name, String surname, Long countryId) {
        Country c = this.countryRepository.findAllById(countryId).orElseThrow(()-> new CountryNotFound(countryId));
        Author a = new Author(id,name,surname,c);
        this.authorRepository.save(a);
        return a;
    }

    @Override
    public Author edit(Long id, String name, String surname, Long countryId) {
        Country c = this.countryRepository.findAllById(countryId).orElseThrow(()-> new CountryNotFound(countryId));
        Author a = this.authorRepository.findById(id).orElseThrow(()->new AuthorNotFound(id));
        a.setName(name);
        a.setSurname(surname);
        a.setContry(c);
        this.authorRepository.save(a);
        return a;
    }

    @Override
    public void delete(Long authorId) {
        this.authorRepository.delete(authorId);
    }

    @Override
    public Optional<Author> findByName(String name) {
        return this.authorRepository.findByName(name);
    }

    @Override
    public Optional<Author> findById(Long id) {
        return this.authorRepository.findById(id);
    }
}
