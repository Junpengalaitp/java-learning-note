package pluralsight.ddd.practice.value.object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void sumOfTwoMoneysProducesSameResult() {
        Money money1 = new Money(1, 2, 3, 4, 5, 6);
        Money money2 = new Money(1, 2, 3, 4, 5, 6);

        Money sum = Money.sumAndGet(money1, money2);

        assertAll(
                () -> assertEquals(2, sum.getOneCentCount()),
                () -> assertEquals(4, sum.getTenCentCount()),
                () -> assertEquals(6, sum.getQuarterCount()),
                () -> assertEquals(8, sum.getOneDollarCount()),
                () -> assertEquals(10, sum.getFiveDollarCount()),
                () -> assertEquals(12, sum.getTwentyDollarCount())
                );
    }

    @Test
    void twoMoneyInstancesEqualIfContainsTheSameAmount() {
        Money money1 = new Money(1, 2, 3, 4, 5, 6);
        Money money2 = new Money(1, 2, 3, 4, 5, 6);
        assertNotSame(money1, money2);
        assertEquals(money1, money2);
    }

    @Test
    void twoMoneyInstancesNotEqualIfContainsTheDifferentAmount() {
        Money money1 = new Money(10, 2, 3, 4, 5, 6);
        Money money2 = new Money(1, 2, 3, 4, 5, 6);
        assertNotEquals(money1, money2);
    }

    @Test
    void cannotCreateMoneyWithNegativeValue() {
        assertThrows(IllegalArgumentException.class, () -> new Money(-1, -2, -3, -4, -5, -6));
    }
}