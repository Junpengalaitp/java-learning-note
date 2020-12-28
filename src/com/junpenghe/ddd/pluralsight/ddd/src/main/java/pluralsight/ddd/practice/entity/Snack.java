package pluralsight.ddd.practice.entity;

import lombok.AllArgsConstructor;
import pluralsight.ddd.practice.aggregate.AggregateRoot;

@AllArgsConstructor
public class Snack extends AggregateRoot {
    private final String name;
}
