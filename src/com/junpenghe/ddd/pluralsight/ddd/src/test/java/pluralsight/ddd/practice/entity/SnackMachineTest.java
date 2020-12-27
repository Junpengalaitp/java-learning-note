package pluralsight.ddd.practice.entity;

import org.junit.jupiter.api.Test;
import pluralsight.ddd.practice.value.object.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class SnackMachineTest {

    @Test
    void returnMoneyEmptiesMoneyInTransaction() {
        var snackMachine = new SnackMachine();
        snackMachine.insertMoney(Money.DOLLAR);
        snackMachine.returnMoney();
        assertEquals(0.0, snackMachine.getMoneyInTransaction().amount());
    }

    @Test
    void insertedMoneyGoesToMoneyInTransaction() {
        var snackMachine = new SnackMachine();
        snackMachine.insertMoney(Money.CENT);
        snackMachine.insertMoney(Money.DOLLAR);
        assertEquals(1.01, snackMachine.getMoneyInTransaction().amount());
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

        snackMachine.buySnack();

        assertEquals(Money.NONE, snackMachine.getMoneyInTransaction());
        assertEquals(2.0, snackMachine.getMoneyInside().amount());
    }
}