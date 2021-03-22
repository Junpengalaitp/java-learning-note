package com.junpenghe.spring.spring.data;

import com.junpenghe.spring.spring.data.entity.Flight;
import com.junpenghe.spring.spring.data.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class DerivedQueryTest {

    @Autowired
    FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    void shouldFindFlightsFromLondon() {
        Flight flight1 = createFlight("London");
        Flight flight2 = createFlight("London");
        Flight flight3 = createFlight("New York");

        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

        List<Flight> flightsFromLondon = flightRepository.findByOrigin("London");

        assertThat(flightsFromLondon)
                .hasSize(2);
        assertThat(flightsFromLondon.get(0))
                .usingRecursiveComparison()
                .isEqualTo(flight1);
        assertThat(flightsFromLondon.get(1))
                .usingRecursiveComparison()
                .isEqualTo(flight2);
    }

    @Test
    void shouldFindFlightsFromLondonToParis() {
        Flight flight1 = createFlight("London", "Paris");
        Flight flight2 = createFlight("London", "New York");
        Flight flight3 = createFlight("New York", "Paris");
        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

        List<Flight> flightsFromLondonToParis = flightRepository.findByOriginAndDestination("London", "Paris");


        assertThat(flightsFromLondonToParis)
                .hasSize(1)
                .first()
                .usingRecursiveComparison()
                .isEqualTo(flight1);
    }

    @Test
    void shouldFindFlightsFromLondonOrMadrid() {
        Flight flight1 = createFlight("London", "Paris");
        Flight flight2 = createFlight("Tokyo", "New York");
        Flight flight3 = createFlight("Madrid", "Paris");
        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

        List<Flight> flightsFromLondonOrMadrid = flightRepository.findByOriginIn("London", "Madrid");


        assertThat(flightsFromLondonOrMadrid)
                .hasSize(2)
                .last()
                .usingRecursiveComparison()
                .isEqualTo(flight3);
    }

    @Test
    void shouldFindFlightsFromLondonIgnoreCase() {
        Flight flight1 = createFlight("LONDON");
        Flight flight2 = createFlight("LONDON");
        Flight flight3 = createFlight("New York");

        flightRepository.saveAll(Arrays.asList(flight1, flight2, flight3));

        List<Flight> flightsFromLondon = flightRepository.findByOriginIgnoreCase("London");

        assertThat(flightsFromLondon)
                .hasSize(2);
        assertThat(flightsFromLondon.get(0))
                .usingRecursiveComparison()
                .isEqualTo(flight1);
        assertThat(flightsFromLondon.get(1))
                .usingRecursiveComparison()
                .isEqualTo(flight2);
    }

    private Flight createFlight(String origin, String destination) {
        Flight flight = createFlight(origin);
        flight.setDestination(destination);
        return flight;
    }

    private Flight createFlight(String origin) {
        Flight flight = new Flight();
        flight.setOrigin(origin);
        flight.setDestination("New York");
        flight.setScheduledAt(LocalDateTime.now());
        return flight;
    }
}
