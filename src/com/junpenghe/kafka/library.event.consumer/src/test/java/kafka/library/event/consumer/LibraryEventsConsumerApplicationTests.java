package kafka.library.event.consumer;

import com.fasterxml.jackson.core.JsonProcessingException;
import kafka.library.event.consumer.config.TopicName;
import kafka.library.event.consumer.consumer.LibraryEventConsumer;
import kafka.library.event.consumer.entity.LibraryEvent;
import kafka.library.event.consumer.repository.LibraryEventsRepository;
import kafka.library.event.consumer.service.LibraryEventService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.listener.MessageListenerContainer;
import org.springframework.kafka.test.EmbeddedKafkaBroker;
import org.springframework.kafka.test.context.EmbeddedKafka;
import org.springframework.kafka.test.utils.ContainerTestUtils;
import org.springframework.test.context.TestPropertySource;

import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@TestPropertySource(properties = {"spring.kafka.producer.bootstrap-servers=${spring.embedded.kafka.brokers}",
    "spring.kafka.consumer.bootstrap-servers=${spring.embedded.kafka.brokers}"})
@EmbeddedKafka(topics = {TopicName.LIBRARY_EVENTS}, partitions = 3)
@SpringBootTest
class LibraryEventsConsumerApplicationTests {

    @Autowired
    private EmbeddedKafkaBroker embeddedKafkaBroker;
    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;
    @Autowired
    private KafkaListenerEndpointRegistry kafkaListenerEndpointRegistry;
    @SpyBean
    private LibraryEventConsumer libraryEventConsumer;
    @SpyBean
    private LibraryEventService libraryEventService;
    @Autowired
    private LibraryEventsRepository libraryEventsRepository;

    @BeforeEach
    void setUp() {
        for (MessageListenerContainer messageListenerContainer : kafkaListenerEndpointRegistry.getListenerContainers()) {
            ContainerTestUtils.waitForAssignment(messageListenerContainer, embeddedKafkaBroker.getPartitionsPerTopic());
        }
    }

    @AfterEach
    void tearDown() {
        libraryEventsRepository.deleteAll();
    }

    @Test
    void publishNewLibraryEvent() throws ExecutionException, InterruptedException, JsonProcessingException {
        // given
        String json = "{\"libraryEventId\":123,\"libraryEventType\":\"NEW\",\"book\":{\"bookId\":456,\"bookName\":\"Kafka Using Spring Boot\",\"bookAuthor\":\"Dilip\"}}";
        kafkaTemplate.send(TopicName.LIBRARY_EVENTS, json).get();
        // when
        Thread.sleep(3000);
        // then
        verify(libraryEventConsumer, times(1)).onMessage(isA(ConsumerRecord.class));
        verify(libraryEventService, times(1)).processLibraryEvent(isA(ConsumerRecord.class));

        Iterable<LibraryEvent> libraryEventList = libraryEventsRepository.findAll();

        assertEquals(1, libraryEventList.spliterator().getExactSizeIfKnown());

        libraryEventList.forEach(libraryEvent -> {
            assertNotNull(libraryEvent.getLibraryEventId());
            assertEquals(456, libraryEvent.getBook().getBookId());
        });
    }

    @Test
    void publishUpdateLibraryEvent() {

    }
}
