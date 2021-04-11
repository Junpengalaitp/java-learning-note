package kafka.producer;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kafka.config.TopicName;
import kafka.domain.LibraryEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.Header;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.util.List;
import java.util.concurrent.ExecutionException;


/**
 * @author Junpeng He
 */
@Component
@Slf4j
public class LibraryEventProducer {

    @Autowired
    private KafkaTemplate<Integer, String> kafkaTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    public void sendLibraryEvent(LibraryEvent libraryEvent) throws JsonProcessingException {
        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);
        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(TopicName.LIBRARY_EVENTS, key, value);
        listenableFuture.addCallback(new CustomCallBack(key, value));
    }

    public ListenableFuture<SendResult<Integer, String>> sendLibraryEventAlternative(LibraryEvent libraryEvent) throws JsonProcessingException {
        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);

        ProducerRecord<Integer, String> producerRecord = buildProducerRecord(key, value, TopicName.LIBRARY_EVENTS);

        ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(producerRecord);
        listenableFuture.addCallback(new CustomCallBack(key, value));

        return listenableFuture;
    }

    private ProducerRecord<Integer, String> buildProducerRecord(Integer key, String value, String topic) {
        List<Header> headers = List.of(new RecordHeader("event-source", "scanner".getBytes()));

        return new ProducerRecord<>(topic, null, key, value, headers);
    }

    public SendResult<Integer, String> sendLibraryEventSync(LibraryEvent libraryEvent) throws JsonProcessingException {
        Integer key = libraryEvent.getLibraryEventId();
        String value = objectMapper.writeValueAsString(libraryEvent);
        SendResult<Integer, String> sendResult = null;
        try {
            ListenableFuture<SendResult<Integer, String>> listenableFuture = kafkaTemplate.send(TopicName.LIBRARY_EVENTS, key, value);
            listenableFuture.addCallback(new CustomCallBack(key, value));
            sendResult = listenableFuture.get();
        } catch (InterruptedException | ExecutionException e) {
            log.error("InterruptedException | ExecutionException Sending the Message and the exception is {}", e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            log.error("Error Sending the Message and the exception is {}", e.getMessage());
            e.printStackTrace();
        }
        return sendResult;
    }


}

@Slf4j
class CustomCallBack implements ListenableFutureCallback<SendResult<Integer, String>> {

    private final Integer key;
    private final String value;

    public CustomCallBack(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    @Override
    public void onFailure(Throwable ex) {
        handleFailure(ex);
    }

    @Override
    public void onSuccess(SendResult<Integer, String> result) {
        handleSuccess(key, value, result);
    }

    private void handleFailure(Throwable throwable) {
        log.error("Error Sending the Message and the exception is {}", throwable.getMessage());
        try {
            throw throwable;
        } catch (Throwable ex) {
            log.error("Error on Failure: {}", ex.getMessage());
        }
    }

    private void handleSuccess(Integer key, String value, SendResult<Integer, String> result) {
        log.info("Message Sent Successfully for the key: {} and the value is: {} partition is {}, value is {}", key, value,
                result.getRecordMetadata().partition(), result.getProducerRecord().value());
    }
}
