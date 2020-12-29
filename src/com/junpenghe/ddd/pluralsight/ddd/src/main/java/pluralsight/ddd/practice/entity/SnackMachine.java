package pluralsight.ddd.practice.entity;

import lombok.Getter;
import lombok.SneakyThrows;
import pluralsight.ddd.practice.aggregate.AggregateRoot;
import pluralsight.ddd.practice.value.object.Money;
import pluralsight.ddd.practice.value.object.SnackPile;

import java.math.BigDecimal;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Getter
public class SnackMachine extends AggregateRoot {
    private Money moneyInside;
    private BigDecimal moneyInTransaction;
    private final List<Slot> slots;

    private static final Set<Money> ACCEPT_COINS_AND_NOTES = Stream.of(Money.CENT, Money.TENCENT, Money.QUARTER,
            Money.DOLLAR, Money.FIVE_DOLLAR, Money.TWENTY_DOLLAR).collect(Collectors.toSet());

    public SnackMachine() {
        super();
        this.moneyInside = Money.NONE;
        this.moneyInTransaction = BigDecimal.ZERO;
        this.slots = List.of(
                new Slot(this, 1),
                new Slot(this, 2),
                new Slot(this, 3)
                );
    }

    public void insertMoney (Money money) {
        if (!ACCEPT_COINS_AND_NOTES.contains(money)) {
            throw new IllegalArgumentException();
        }
        moneyInTransaction = moneyInTransaction.add(BigDecimal.valueOf(money.amount()));
        moneyInside = moneyInside.add(money);
    }

    public void returnMoney() {
        Money moneyToReturn = moneyInside.allocate(moneyInTransaction);
        moneyInside = moneyInside.subtract(moneyToReturn);
        moneyInTransaction = BigDecimal.ZERO;
    }

    @SneakyThrows
    public void buySnack(int position) {
        Slot slot = getSlotByPosition(position);
        if (slot.getSnackPile().getPrice() > moneyInTransaction.doubleValue()) {
            throw new IllegalAccessException("no sufficient fund");
        }
        if (slot.getSnackPile().getQuantity() <= 0) {
            throw new IllegalAccessException("no sufficient snacks");
        }
        slot.setSnackPile(slot.getSnackPile().subtractOne());

        Money change = moneyInside.allocate(moneyInTransaction.subtract(BigDecimal.valueOf(slot.getSnackPile().getPrice())));
        if (change.amount() < moneyInTransaction.doubleValue() - slot.getSnackPile().getPrice()) {
            throw new IllegalAccessException();
        }
        moneyInside = moneyInside.subtract(change);

        moneyInTransaction = BigDecimal.ZERO;
    }

    public void loadSnacks(int position, SnackPile snackPile) {
        Slot slot = slots.get(position);
        slot.setSnackPile(snackPile);
    }

    private Slot getSlotByPosition(int position) {
        return slots.get(position);
    }

    public SnackPile getSnackPileByPosition(int position) {
        return getSlotByPosition(position).getSnackPile();
    }

    public void loadMoney(Money money) {
        moneyInside = moneyInside.add(money);
    }
}
