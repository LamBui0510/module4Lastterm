package com.example.testmd4.service;

import com.example.testmd4.model.City;
import com.example.testmd4.model.Country;

import java.util.List;

public interface ICountryService {
    List<Country> findAll();
}
