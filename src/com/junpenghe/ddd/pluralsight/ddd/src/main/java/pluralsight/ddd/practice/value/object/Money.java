package pluralsight.ddd.practice.value.object;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;


@Value
@Getter
@Builder
public class Money {
    int oneCentCount;
    int tenCentCount;
    int quarterCount;
    int oneDollarCount;
    int fiveDollarCount;
    int twentyDollarCount;

    public Money(int oneCentCount, int tenCentCount, int quarterCount, int oneDollarCount, int fiveDollarCount, int twentyDollarCount) {
        if (oneCentCount < 0) {
            throw new IllegalArgumentException();
        }
        if (tenCentCount < 0) {
            throw new IllegalArgumentException();
        }
        if (quarterCount < 0) {
            throw new IllegalArgumentException();
        }
        if (oneDollarCount < 0) {
            throw new IllegalArgumentException();
        }
        if (fiveDollarCount < 0) {
            throw new IllegalArgumentException();
        }
        if (twentyDollarCount < 0) {
            throw new IllegalArgumentException();
        }

        this.oneCentCount = oneCentCount;
        this.tenCentCount = tenCentCount;
        this.quarterCount = quarterCount;
        this.oneDollarCount = oneDollarCount;
        this.fiveDollarCount = fiveDollarCount;
        this.twentyDollarCount = twentyDollarCount;
    }

    public static Money sumAndGet(Money money, Money moneyToAdd) {
        return Money.builder()
                .oneCentCount(money.oneCentCount + moneyToAdd.oneCentCount)
                .tenCentCount(money.tenCentCount + moneyToAdd.tenCentCount)
                .quarterCount(money.quarterCount + moneyToAdd.quarterCount)
                .oneDollarCount(money.oneDollarCount + moneyToAdd.oneDollarCount)
                .fiveDollarCount(money.fiveDollarCount + moneyToAdd.fiveDollarCount)
                .twentyDollarCount(money.twentyDollarCount + moneyToAdd.twentyDollarCount)
                .build();
    }

    public static Money subtractAndGet(Money money, Money moneyToAdd) {
        return Money.builder()
                .oneCentCount(money.oneCentCount - moneyToAdd.oneCentCount)
                .tenCentCount(money.tenCentCount - moneyToAdd.tenCentCount)
                .quarterCount(money.quarterCount - moneyToAdd.quarterCount)
                .oneDollarCount(money.oneDollarCount - moneyToAdd.oneDollarCount)
                .fiveDollarCount(money.fiveDollarCount - moneyToAdd.fiveDollarCount)
                .twentyDollarCount(money.twentyDollarCount - moneyToAdd.twentyDollarCount)
                .build();
    }

    public double amount() {
        return oneCentCount * 0.01 + tenCentCount * 0.1 + quarterCount * 0.25 + oneDollarCount + fiveDollarCount * 5
                + twentyDollarCount * 20;
    }
}
