package com.example.APICustomQueries01.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Flight {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;


    private String description;
    private String fromAirport;
    private String toAirport;
    private Status status;


    public Flight(String description, String fromAirport, String toAirport, Status status){

        this.description = description;
        this.fromAirport = fromAirport;
        this.toAirport = toAirport;
        this.status = status;

    }

}
