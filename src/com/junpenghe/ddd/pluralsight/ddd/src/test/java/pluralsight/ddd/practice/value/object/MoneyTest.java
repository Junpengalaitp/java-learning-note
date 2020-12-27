package pluralsight.ddd.practice.value.object;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MoneyTest {

    @Test
    void sumOfTwoMoneysProducesSameResult() {
        Money money1 = new Money(1, 2, 3, 4, 5, 6);
        Money money2 = new Money(1, 2, 3, 4, 5, 6);

        Money sum = money1.add(money2);

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

    @Test
    void amountIsCalculatedCorrectly() {
        Money money = new Money(1, 2, 3, 4, 5, 6);
        assertEquals(149.96, money.amount());
    }

    @Test
    void subtractionOfTwoMoneyProducesCorrectResult() {
        Money money1 = new Money(10, 10, 10, 10, 10, 10);
        Money money2 = new Money(1, 2, 3, 4, 5, 6);
        Money result = money1.subtract(money2);

        assertAll(
                () -> assertEquals(9, result.getOneCentCount()),
                () -> assertEquals(8, result.getTenCentCount()),
                () -> assertEquals(7, result.getQuarterCount()),
                () -> assertEquals(6, result.getOneDollarCount()),
                () -> assertEquals(5, result.getFiveDollarCount()),
                () -> assertEquals(4, result.getTwentyDollarCount())
        );
    }

    @Test
    void canNotSubtractMoreThanExists() {
        Money money1 = new Money(0, 1, 0, 0, 0, 0);
        Money money2 = new Money(1, 0, 0, 0, 0, 0);
    }
}