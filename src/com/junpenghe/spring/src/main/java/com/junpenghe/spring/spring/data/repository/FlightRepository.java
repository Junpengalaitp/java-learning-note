package com.junpenghe.spring.spring.data.repository;

import com.junpenghe.spring.spring.data.entity.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FlightRepository extends CrudRepository<Flight, Long> {
    List<Flight> findByOrigin(String origin);

    List<Flight> findByOriginAndDestination(String origin, String destination);

    List<Flight> findByOriginIn(String... origin);

    List<Flight> findByOriginIgnoreCase(String origin);
}
