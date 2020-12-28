package pluralsight.ddd.practice.value.object;

import lombok.Builder;
import lombok.Getter;
import lombok.Value;

import java.math.BigDecimal;


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

    public Money allocate(BigDecimal amount) {
        int twentyDollarCount = Math.min(amount.divide(BigDecimal.valueOf(20)).intValue(), this.twentyDollarCount);
        amount = amount.subtract(BigDecimal.valueOf(twentyDollarCount * 20L));

        int fiveDollarCount = Math.min(amount.divide(BigDecimal.valueOf(5)).intValue(), this.fiveDollarCount);
        amount = amount.subtract(BigDecimal.valueOf(fiveDollarCount * 5L));

        int oneDollarCount = Math.min(amount.intValue(), this.oneDollarCount);
        amount = amount.subtract(BigDecimal.valueOf(oneDollarCount));

        int quarterCount = Math.min(amount.divide(BigDecimal.valueOf(0.25)).intValue(), this.quarterCount);
        amount = amount.subtract(BigDecimal.valueOf(quarterCount * 0.25));

        int tenCentCount = Math.min(amount.divide(BigDecimal.valueOf(0.1)).intValue(), this.tenCentCount);
        amount = amount.subtract(BigDecimal.valueOf(tenCentCount * 0.1));

        int oneCentCount = Math.min(amount.divide(BigDecimal.valueOf(0.01)).intValue(), this.oneCentCount);

        return new Money(oneCentCount, tenCentCount, quarterCount, oneDollarCount, fiveDollarCount, twentyDollarCount);
    }
}
