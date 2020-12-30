package pluralsight.ddd.practice.management;

import pluralsight.ddd.practice.aggregate.AggregateRoot;
import pluralsight.ddd.practice.value.object.Money;

import java.math.BigDecimal;

/**
 * @author Junpeng He
 */
public class HeadOffice extends AggregateRoot {
    private BigDecimal balance;
    private Money cash;
}
