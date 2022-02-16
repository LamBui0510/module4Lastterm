package com.example.testmd4.repository;

import com.example.testmd4.model.City;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICityRepo extends JpaRepository<City, Long> {
    @Query(value = " select u from City u where u.cityName like concat('%' ,:name, '%')")
    Page<City> findAllByName(@Param("name") String name, Pageable pageable);
}
