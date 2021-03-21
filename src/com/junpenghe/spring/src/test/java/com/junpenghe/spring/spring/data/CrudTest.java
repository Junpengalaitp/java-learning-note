package com.junpenghe.spring.spring.data;

import com.junpenghe.spring.spring.data.entity.Flight;
import com.junpenghe.spring.spring.data.repository.FlightRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class CrudTest {

    @Autowired
    FlightRepository flightRepository;

    @Test
    void shouldPerformCRUDOperations() {
        Flight flight = new Flight();
        flight.setOrigin("London");
        flight.setDestination("New York");
        flight.setScheduledAt(LocalDateTime.now());

        flightRepository.save(flight);

        assertThat(flightRepository.findAll())
                .hasSize(1)
                .first()
                .isEqualTo(flight)
                .usingRecursiveComparison();

        flightRepository.deleteById(flight.getId());

        assertThat(flightRepository.count()).isZero();
    }
}
