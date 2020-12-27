package pluralsight.ddd.practice.entity;


import java.util.UUID;

public abstract class Entity {
    protected final String id;

    protected Entity() {
        this.id = UUID.randomUUID().toString();
    }
}
