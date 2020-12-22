package kafka.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import kafka.domain.LibraryEvent;
import kafka.domain.LibraryEventType;
import kafka.producer.LibraryEventProducer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class LibraryEventController {

    @Autowired
    private LibraryEventProducer libraryEventProducer;


    @PostMapping("/v1/libraryevent")
    public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody LibraryEvent libraryEvent) throws JsonProcessingException {
        // invoke kafka producer
        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
        libraryEventProducer.sendLibraryEvent(libraryEvent);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(libraryEvent);
    }
}
