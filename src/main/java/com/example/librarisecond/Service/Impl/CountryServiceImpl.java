package com.example.librarisecond.Service.Impl;

import com.example.librarisecond.Repository.CountryRepository;
import com.example.librarisecond.Service.CountryService;
import com.example.librarisecond.model.Country;
import com.example.librarisecond.model.exeptions.CountryNotFound;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;

    public CountryServiceImpl(CountryRepository countryRepository) {
        this.countryRepository = countryRepository;
    }

    @Override
    public List<Country> listAll() {
        return this.countryRepository.findAll();
    }

    @Override
    public Country create(int id,String name, String continent) {
        Country c = new Country(id,name,continent);
        this.countryRepository.save(c);
        return c;
    }

    @Override
    public Country edit(Long id, String name, String continent) {
        Country c = this.countryRepository.findAllById(id).orElseThrow(()->new CountryNotFound(id));
        c.setName(name);
        c.setContinent(continent);
        this.countryRepository.save(c);
        return c;
    }

    @Override
    public void delete(Long countryId) {
        this.countryRepository.delete(countryId);
    }

    @Override
    public Optional<Country> findByName(String name) {
        return this.countryRepository.findByName(name);
    }

    @Override
    public Optional<Country> findById(Long id) {
        return this.countryRepository.findAllById(id);
    }
}
