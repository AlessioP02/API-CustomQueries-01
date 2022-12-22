package com.example.APICustomQueries01.controllers;

import com.example.APICustomQueries01.entities.Flight;
import com.example.APICustomQueries01.entities.Status;
import com.example.APICustomQueries01.repositorys.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    private FlightRepo flightRepo;

    @PostMapping("")
    public List<Flight> flights(){

        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();

        List<Flight> flightsDb = new ArrayList<>();


        for (int i =0; i<49; i++) {

            String description = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            String fromArport = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            String toAirport = random.ints(leftLimit, rightLimit + 1)
                    .limit(targetStringLength)
                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                    .toString();

            Flight flight = new Flight(description, fromArport, toAirport, Status.ONTIME);

            flightsDb.add(flight);
        }

        return flightsDb;
    }

    @GetMapping("")
    public List<Flight> getFlights(){

        return flightRepo.findAll();
    }
}
