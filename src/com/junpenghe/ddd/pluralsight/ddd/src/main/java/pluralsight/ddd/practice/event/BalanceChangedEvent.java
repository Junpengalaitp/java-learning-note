package pluralsight.ddd.practice.event;

import lombok.Getter;

import java.math.BigDecimal;

@Getter
public class BalanceChangedEvent implements DomainEvent {
    private final BigDecimal delta;

    public BalanceChangedEvent(BigDecimal delta) {
        this.delta = delta;
    }
}
