package com.junpenghe.spring.spring.data;

import com.junpenghe.spring.spring.data.entity.Flight;
import com.junpenghe.spring.spring.data.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Iterator;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class PagingAndSortingTest {

    @Autowired
    FlightRepository flightRepository;

    @BeforeEach
    void setUp() {
        flightRepository.deleteAll();
    }

    @Test
    void shouldSortFlightsByDestination() {
        Flight madrid = createFlight("Madrid");
        Flight london = createFlight("London");
        Flight paris = createFlight("Paris");

        flightRepository.saveAll(Arrays.asList(madrid, london, paris));

        Iterable<Flight> flights = flightRepository.findAll(Sort.by("destination"));

        Iterator<Flight> iterator = flights.iterator();

        assertThat(flights)
                .hasSize(3);
        assertThat(iterator.next().getDestination()).isEqualTo("London");
        assertThat(iterator.next().getDestination()).isEqualTo("Madrid");
        assertThat(iterator.next().getDestination()).isEqualTo("Paris");

    }

    @Test
    void shouldSortFlightsByDestinationAndSchedule() {
        LocalDateTime now = LocalDateTime.now();
        Flight paris1 = createFlight("Paris", now);
        Flight paris2 = createFlight("Paris", now.plusHours(2));
        Flight paris3 = createFlight("Paris", now.minusHours(1));
        Flight london1 = createFlight("London", now.plusHours(1));
        Flight london2 = createFlight("London", now);


        flightRepository.saveAll(Arrays.asList(paris1, paris2, paris3, london1, london2));

        Iterable<Flight> flights = flightRepository.findAll(Sort.by("destination", "scheduledAt"));

        Iterator<Flight> iterator = flights.iterator();

        assertThat(flights).hasSize(5);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(london2);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(london1);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris3);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris1);
        assertThat(iterator.next()).usingRecursiveComparison().isEqualTo(paris2);

    }

    @Test
    void shouldPageResult() {
        IntStream.range(0, 50).forEach(i -> flightRepository.save(createFlight(String.valueOf(i))));

        Page<Flight> page = flightRepository.findAll(PageRequest.of(2, 5));

        assertThat(page.getTotalElements()).isEqualTo(50);
        assertThat(page.getNumberOfElements()).isEqualTo(5);
        assertThat(page.getTotalPages()).isEqualTo(10);
        assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("10", "11", "12", "13", "14");
    }

    @Test
    void shouldPageAndSortResult() {
        IntStream.range(0, 50).forEach(i -> flightRepository.save(createFlight(String.valueOf(i))));

        Page<Flight> page = flightRepository.findAll(PageRequest.of(2, 5, Sort.by(Sort.Direction.DESC, "destination")));

        assertThat(page.getTotalElements()).isEqualTo(50);
        assertThat(page.getNumberOfElements()).isEqualTo(5);
        assertThat(page.getTotalPages()).isEqualTo(10);
        assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("44", "43", "42", "41", "40");
    }

    @Test
    void shouldPageAndSortADerivedQuery() {
        IntStream.range(0, 10).forEach(i -> {
            Flight flight = createFlight(String.valueOf(i));
            flight.setOrigin("Paris");
            flightRepository.save(flight);
        });

        IntStream.range(0, 10).forEach(i -> {
            Flight flight = createFlight(String.valueOf(i));
            flight.setOrigin("London");
            flightRepository.save(flight);
        });

        Page<Flight> page = flightRepository.findByOrigin("London", PageRequest.of(0, 5, Sort.by(Sort.Direction.DESC, "destination")));

        assertThat(page.getTotalElements()).isEqualTo(10);
        assertThat(page.getNumberOfElements()).isEqualTo(5);
        assertThat(page.getTotalPages()).isEqualTo(2);
        assertThat(page.getContent())
                .extracting(Flight::getDestination)
                .containsExactly("9", "8", "7", "6", "5");
    }

    private Flight createFlight(String destination) {
        Flight flight = new Flight();
        flight.setOrigin("London");
        flight.setDestination(destination);
        flight.setScheduledAt(LocalDateTime.now());
        return flight;
    }

    private Flight createFlight(String destination, LocalDateTime scheduledAt) {
        Flight flight = createFlight(destination);
        flight.setScheduledAt(scheduledAt);
        return flight;
    }
}
