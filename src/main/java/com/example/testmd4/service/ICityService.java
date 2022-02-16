package com.example.testmd4.service;

import com.example.testmd4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICityService {
    Page<City> findAll(Pageable pageable);
    void save(City city);
    void delete(long id);
    City findById(long id);
    Page<City> findUsersByName(String name, Pageable pageable);
}
