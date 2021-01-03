package pluralsight.ddd.practice.event;

public interface Handler<T extends DomainEvent> {
    void handle(T domainEvent);
}
