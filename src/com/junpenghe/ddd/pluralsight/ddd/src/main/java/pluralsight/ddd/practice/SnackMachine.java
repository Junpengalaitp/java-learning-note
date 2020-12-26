package pluralsight.ddd.practice;

import lombok.Data;

@Data
public class SnackMachine {
    private Money moneyInside;
    private Money moneyInTransaction;

    public void insertMoney (Money money) {
        moneyInTransaction = moneyInTransaction.sumAndGet(moneyInTransaction, money);
    }

    public void returnMoney() {
    }

    public void buySnack() {
        moneyInside = moneyInside.sumAndGet(moneyInside, moneyInTransaction);
    }
}
