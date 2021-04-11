package kafka.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.kafka.config.TopicBuilder;

/**
 * @author Junpeng He
 */
@Configuration
@Profile("local")
public class AutoCreateConfig {

    @Bean
    public NewTopic libraryEvents() {
        return TopicBuilder.name(TopicName.LIBRARY_EVENTS)
                .partitions(3)
                .replicas(3)
                .build();
    }
}
