package pluralsight.ddd.practice.event;

import pluralsight.ddd.practice.aggregate.AggregateRoot;

public class EventListener {

    private void dispatchEvents(AggregateRoot aggregateRoot) {
        aggregateRoot.getDomainEvents().forEach(
                DomainEvents::dispatch
        );
        aggregateRoot.clearEvents();
    }
}
