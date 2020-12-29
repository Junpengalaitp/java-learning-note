package pluralsight.ddd.practice.entity;


import lombok.Getter;

import java.util.UUID;

@Getter
public abstract class Entity {
    protected final String id;

    protected Entity() {
        this.id = UUID.randomUUID().toString();
    }
}
