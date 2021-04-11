package kafka.library.event.consumer.repository;

import kafka.library.event.consumer.entity.LibraryEvent;
import org.springframework.data.repository.CrudRepository;

public interface LibraryEventsRepository extends CrudRepository<LibraryEvent, Integer> {

}
