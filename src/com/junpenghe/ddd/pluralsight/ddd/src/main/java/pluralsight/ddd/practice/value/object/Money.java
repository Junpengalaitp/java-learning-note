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

    public static final Money NONE = new Money(0, 0, 0, 0, 0, 0);
    public static final Money CENT = new Money(1, 0, 0, 0, 0, 0);
    public static final Money TENCENT = new Money(0, 1, 0, 0, 0, 0);
    public static final Money QUARTER = new Money(0, 0, 1, 0, 0, 0);
    public static final Money DOLLAR = new Money(0, 0, 0, 1, 0, 0);
    public static final Money FIVE_DOLLAR = new Money(0, 0, 0, 0, 1, 0);
    public static final Money TWENTY_DOLLAR = new Money(0, 0, 0, 0, 0, 1);

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

    public Money add(Money moneyToAdd) {
        return Money.builder()
                .oneCentCount(this.oneCentCount + moneyToAdd.oneCentCount)
                .tenCentCount(this.tenCentCount + moneyToAdd.tenCentCount)
                .quarterCount(this.quarterCount + moneyToAdd.quarterCount)
                .oneDollarCount(this.oneDollarCount + moneyToAdd.oneDollarCount)
                .fiveDollarCount(this.fiveDollarCount + moneyToAdd.fiveDollarCount)
                .twentyDollarCount(this.twentyDollarCount + moneyToAdd.twentyDollarCount)
                .build();
    }

    public Money subtract(Money moneyToSubtract) {
        return Money.builder()
                .oneCentCount(this.oneCentCount - moneyToSubtract.oneCentCount)
                .tenCentCount(this.tenCentCount - moneyToSubtract.tenCentCount)
                .quarterCount(this.quarterCount - moneyToSubtract.quarterCount)
                .oneDollarCount(this.oneDollarCount - moneyToSubtract.oneDollarCount)
                .fiveDollarCount(this.fiveDollarCount - moneyToSubtract.fiveDollarCount)
                .twentyDollarCount(this.twentyDollarCount - moneyToSubtract.twentyDollarCount)
                .build();
    }

    public double amount() {
        return oneCentCount * 0.01 + tenCentCount * 0.1 + quarterCount * 0.25 + oneDollarCount + fiveDollarCount * 5
                + twentyDollarCount * 20;
    }
}
