package pluralsight.ddd.practice.event;

import java.util.List;

public class DomainEvents {
    private static List<Class<?>> handlers;


    public static <T extends DomainEvent> void dispatch(T domainEvent) {
        handlers.forEach(h -> {
            if (h.equals(domainEvent.getClass())) {

            }
        });
    }
}
