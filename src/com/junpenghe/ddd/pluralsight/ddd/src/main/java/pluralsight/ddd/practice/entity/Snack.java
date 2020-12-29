package pluralsight.ddd.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import pluralsight.ddd.practice.aggregate.AggregateRoot;

@Getter
@AllArgsConstructor
public class Snack extends AggregateRoot {
    private final String name;
}
