package pluralsight.ddd.practice.aggregate;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

/**
 * @author Junpeng He
 */
@Setter
@Getter
public class AggregateRoot {
//    private final int version;
//    private final List<?> events = new ArrayList<>();
//
//    public AggregateRoot(int version) {
//        this.version = version;
//    }
    protected final String id;

    public AggregateRoot() {
        this.id = UUID.randomUUID().toString();
    }
}
