package com.example.APICustomQueries01.repositorys;

import com.example.APICustomQueries01.entities.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight, Long> {
}
