package kafka.library.event.consumer.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import kafka.library.event.consumer.config.TopicName;
import kafka.library.event.consumer.service.LibraryEventService;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class LibraryEventConsumer {

    @Autowired
    private LibraryEventService libraryEventService;

    @KafkaListener(topics = {TopicName.LIBRARY_EVENTS})
    public void onMessage(ConsumerRecord<Integer, String> consumerRecord) throws JsonProcessingException {
        log.info("ConsumerRecord: {}", consumerRecord);
        libraryEventService.processLibraryEvent(consumerRecord);
    }
}
