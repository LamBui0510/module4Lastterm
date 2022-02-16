package com.example.testmd4.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@Entity
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
//    @NotNull(message = "not null")
    private String cityName;
//    @Size(min = 0, message = "larger than 0")
    private double squares;
//    @Size(min = 0 , message = "larger than 0")
    private double population;
//    @Size(min = 0 , message = "larger than 0")
    private double gdp;
//    @NotNull(message =  "notNull")
    private String description;
    @ManyToOne
    private Country country;
}
