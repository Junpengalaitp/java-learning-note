package com.junpenghe.spring.spring.data;

import com.junpenghe.spring.spring.data.entity.Flight;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class SpringBootDemoApplicationTests {

    @Autowired
    private EntityManager entityManager;

    @Test
    void flightCanBeSaved() {
        final Flight flight = new Flight();
        flight.setOrigin("Amsterdam");
        flight.setDestination("New York");
        flight.setScheduledAt(LocalDateTime.now());

        entityManager.persist(flight);

        final TypedQuery<Flight> results = entityManager.createQuery("SELECT f FROM Flight f", Flight.class);

        final List<Flight> resultList = results.getResultList();

        assertThat(resultList)
                .hasSize(1)
                .first()
                .isEqualTo(flight);
    }

}
