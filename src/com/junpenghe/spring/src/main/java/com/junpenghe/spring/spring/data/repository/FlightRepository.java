package com.junpenghe.spring.spring.data.repository;

import com.junpenghe.spring.spring.data.entity.Flight;
import org.springframework.data.repository.CrudRepository;

public interface FlightRepository extends CrudRepository<Flight, Long> {
}
