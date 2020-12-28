package pluralsight.ddd.practice.entity;

import org.junit.jupiter.api.Test;
import pluralsight.ddd.practice.value.object.Money;
import pluralsight.ddd.practice.value.object.SnackPile;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SnackMachineTest {

    @Test
    void returnMoneyEmptiesMoneyInTransaction() {
        var snackMachine = new SnackMachine();
        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.returnMoney();
        assertEquals(0.0, snackMachine.getMoneyInTransaction().doubleValue());
    }

    @Test
    void insertedMoneyGoesToMoneyInTransaction() {
        var snackMachine = new SnackMachine();
        snackMachine.insertMoney(Money.CENT);
        snackMachine.insertMoney(Money.DOLLAR);
        assertEquals(1.01, snackMachine.getMoneyInTransaction().doubleValue());
    }

    @Test
    void cannotInsertMoreThanOneCoinOrNoteAtATime() {
        var snackMachine = new SnackMachine();
        Money money = Money.CENT.add(Money.CENT);
        assertThrows(IllegalArgumentException.class, () -> snackMachine.insertMoney(money));
    }

    @Test
    void moneyInTransactionGoesToMoneyInsideAfterPurchase() {
        var snackMachine = new SnackMachine();
        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.loadSnacks(1, new SnackPile(new Snack("Some snack"), 10, 1.0));
        snackMachine.buySnack(1);

        assertEquals(BigDecimal.ZERO, snackMachine.getMoneyInTransaction());
        assertEquals(1, snackMachine.getMoneyInside().amount());
    }

    @Test
    void buySnackTradesInsertedMoneyForASnack() {
        var snackMachine = new SnackMachine();
        snackMachine.loadSnacks(1, new SnackPile(new Snack("Some snack"), 10, 1.0));
        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.buySnack(1);
        assertEquals(BigDecimal.ZERO, snackMachine.getMoneyInTransaction());
        assertEquals(1, snackMachine.getMoneyInside().amount());
        assertEquals(9, snackMachine.getSnackPileByPosition(1).getQuantity());
    }

    @Test
    void cannotMakePurchaseWhenNoSnacks() {
        var snackMachine = new SnackMachine();
        assertThrows(IllegalAccessException.class, () -> snackMachine.buySnack(1));
    }

    @Test
    void cannotMakePurchaseWhenNoMoney() {
        var snackMachine = new SnackMachine();
        snackMachine.loadSnacks(1, new SnackPile(new Snack("Some snack"), 10, 1.0));
        assertThrows(IllegalAccessException.class, () -> snackMachine.buySnack(1));
    }

    @Test
    void snackMachineReturnsMoneyWithHighestDenominationFirst() {
        var snackMachine = new SnackMachine();
        snackMachine.loadMoney(Money.DOLLAR);

        snackMachine.insertMoney(Money.QUARTER);
        snackMachine.insertMoney(Money.QUARTER);
        snackMachine.insertMoney(Money.QUARTER);
        snackMachine.insertMoney(Money.QUARTER);
        snackMachine.returnMoney();

        assertEquals(4, snackMachine.getMoneyInside().getQuarterCount());
        assertEquals(0, snackMachine.getMoneyInside().getOneDollarCount());
    }

    @Test
    void afterPurchaseChangeIsReturned() {
        var snackMachine = new SnackMachine();
        snackMachine.loadSnacks(1, new SnackPile(new Snack("Some snack"), 10, 0.5));
        snackMachine.loadMoney(new Money(0,10, 0, 0, 0, 0));

        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.buySnack(1);

        assertEquals(1.5, snackMachine.getMoneyInside().amount());
        assertEquals(0.0, snackMachine.getMoneyInTransaction().doubleValue());
    }
}