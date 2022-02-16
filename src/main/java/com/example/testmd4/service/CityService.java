package com.example.testmd4.service;

import com.example.testmd4.model.City;
import com.example.testmd4.repository.ICityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CityService implements ICityService{
    @Autowired
    ICityRepo iCityRepo;
    @Override
    public Page<City> findAll(Pageable pageable) {
        return iCityRepo.findAll(pageable);
    }

    @Override
    public void save(City city) {
    iCityRepo.save(city);
    }

    @Override
    public void delete(long id) {
    iCityRepo.deleteById(id);
    }

    @Override
    public City findById(long id) {
        return iCityRepo.findById(id).get();
    }

    @Override
    public Page<City> findUsersByName(String name, Pageable pageable) {
        return iCityRepo.findAllByName(name, pageable);
    }
}
