package pluralsight.ddd.practice.entity;

import pluralsight.ddd.practice.value.object.Money;


public class SnackMachine extends Entity {
    private Money moneyInside;
    private Money moneyInTransaction;

    public SnackMachine(long id) {
        super(id);
    }

    public void insertMoney (Money money) {
        moneyInTransaction = Money.sumAndGet(moneyInTransaction, money);
    }

    public void returnMoney() {
    }

    public void buySnack() {
        moneyInside = Money.sumAndGet(moneyInside, moneyInTransaction);
    }
}
