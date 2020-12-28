package pluralsight.ddd.practice.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import pluralsight.ddd.practice.value.object.SnackPile;

@AllArgsConstructor
@Getter
@Setter
public class Slot extends Entity {

    private SnackMachine snackMachine;
    private int position;
    private SnackPile snackPile;

    public Slot(SnackMachine snackMachine, int position) {
        this.snackMachine = snackMachine;
        this.position = position;
        this.snackPile = new SnackPile(null, 0, 0.0);
    }
}
