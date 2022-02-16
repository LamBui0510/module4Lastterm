package com.example.testmd4.service;

import com.example.testmd4.model.Country;
import com.example.testmd4.repository.ICountryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CountryService implements ICountryService{
    @Autowired
    ICountryRepo iCountryRepo;
    @Override
    public List<Country> findAll() {
        return iCountryRepo.findAll();
    }
}
