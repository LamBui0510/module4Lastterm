package com.example.testmd4.repository;


import com.example.testmd4.model.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ICountryRepo extends JpaRepository<Country, Long> {

}
