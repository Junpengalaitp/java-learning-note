package pluralsight.ddd.practice.value.object;

import lombok.Value;
import pluralsight.ddd.practice.entity.Snack;

@Value
public class SnackPile {
    Snack snack;
    int quantity;
    double price;

    public SnackPile(Snack snack, int quantity, double price) {
        if (quantity < 0 || price < 0 || price % 0.01 > 0) {
            throw new IllegalArgumentException();
        }
        this.snack = snack;
        this.quantity = quantity;
        this.price = price;
    }

    public SnackPile subtractOne() {
        return new SnackPile(snack, quantity - 1, price);
    }
}
