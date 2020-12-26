package pluralsight.ddd.practice.entity;

import lombok.Data;

@Data
public abstract class Entity {
    private final long id;
}
