package pluralsight.ddd.practice.aggregate;

import lombok.Getter;
import lombok.Setter;
import pluralsight.ddd.practice.event.DomainEvent;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Junpeng He
 */
@Setter
@Getter
public class AggregateRoot {
    protected final String id;
    private final List<DomainEvent> domainEvents = new ArrayList<>();

    public AggregateRoot() {
        this.id = UUID.randomUUID().toString();
    }

    protected void addDomainEvent(DomainEvent domainEvent) {
        domainEvents.add(domainEvent);
    }

    public void clearEvents() {
        domainEvents.clear();
    }
}
