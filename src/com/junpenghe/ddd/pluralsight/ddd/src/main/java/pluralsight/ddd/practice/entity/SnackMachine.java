package pluralsight.ddd.practice.entity;

import lombok.Getter;
import pluralsight.ddd.practice.aggregate.AggregateRoot;
import pluralsight.ddd.practice.model.SnackMachineModel;
import pluralsight.ddd.practice.value.object.Money;
import pluralsight.ddd.practice.value.object.SnackPile;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@Getter
public class SnackMachine extends AggregateRoot {
    private Money moneyInside;
    private Money moneyInTransaction;
    private final List<Slot> slots;

    private static final Set<Money> ACCEPT_COINS_AND_NOTES = Stream.of(Money.CENT, Money.TENCENT, Money.QUARTER,
            Money.DOLLAR, Money.FIVE_DOLLAR, Money.TWENTY_DOLLAR).collect(Collectors.toSet());

    public SnackMachine() {
        super();
        this.moneyInside = Money.NONE;
        this.moneyInTransaction = Money.NONE;
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
        moneyInTransaction = moneyInTransaction.add(money);
    }

    public void returnMoney() {
        moneyInTransaction = Money.NONE;
    }

    public void buySnack(int position) {
        Slot slot = getSlotByPosition(position);
        slot.setSnackPile(slot.getSnackPile().subtractOne());

        moneyInside = moneyInside.add(moneyInTransaction);
        moneyInTransaction = Money.NONE;
    }

    public SnackMachineModel snackMachineModel() {
        return SnackMachineModel.builder()
//                .id(id)
                .oneCentCount(moneyInside.getOneCentCount())
                .tenCentCount(moneyInside.getTenCentCount())
                .quarterCount(moneyInside.getQuarterCount())
                .oneDollarCount(moneyInside.getOneDollarCount())
                .fiveDollarCount(moneyInside.getFiveDollarCount())
                .twentyDollarCount(moneyInside.getTwentyDollarCount())
                .build();
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
}
