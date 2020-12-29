package pluralsight.ddd.practice.atm;

import org.junit.jupiter.api.Test;
import pluralsight.ddd.practice.value.object.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;

class AtmTest {

    @Test
    void takeMoneyExchangesMoneyWithCommission() {
        Atm atm = new Atm();
        atm.loadMoney(Money.DOLLAR);
        atm.takeMoney(1.0);

        assertEquals(0, atm.getMoneyInside().amount());
        assertEquals(1.01, atm.getMoneyCharged().doubleValue());
    }

    @Test
    void commissionIsAtLeastOneCent() {
        Atm atm = new Atm();
        atm.loadMoney(Money.CENT);
        atm.takeMoney(0.01);
        assertEquals(0.02, atm.getMoneyCharged().doubleValue());
    }

    @Test
    void commissionIsRoundedUpToNextCent() {
        Atm atm = new Atm();
        atm.loadMoney(Money.TENCENT.add(Money.DOLLAR));
        atm.takeMoney(1.1);
        assertEquals(1.12, atm.getMoneyCharged().doubleValue());
    }
}