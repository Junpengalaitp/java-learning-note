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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@RestController
@Slf4j
public class LibraryEventController {

    @Autowired
    private LibraryEventProducer libraryEventProducer;


    @PostMapping("/v1/libraryevent")
    public ResponseEntity<LibraryEvent> postLibraryEvent(@RequestBody @Valid LibraryEvent libraryEvent) throws JsonProcessingException {
        // invoke kafka producer
        libraryEvent.setLibraryEventType(LibraryEventType.NEW);
        libraryEventProducer.sendLibraryEventSync(libraryEvent);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(libraryEvent);
    }

    @PutMapping("/v1/libraryevent")
    public ResponseEntity<?> putLibraryEvent(@RequestBody @Valid LibraryEvent libraryEvent) throws JsonProcessingException {
        if (libraryEvent.getLibraryEventId() == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body("Please pass the Library Event Id");
        }
        // invoke kafka producer
        libraryEvent.setLibraryEventType(LibraryEventType.UPDATE);
        libraryEventProducer.sendLibraryEventAlternative(libraryEvent);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(libraryEvent);
    }
}
