package pluralsight.ddd.practice;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Money {
    private int oneCentCount;
    private int tenCentCount;
    private int quarterCount;
    private int oneDollarCount;
    private int fiveDollarCount;
    private int twentyDollarCount;

    public Money sumAndGet(Money money, Money moneyToAdd) {
        return Money.builder()
                .oneCentCount(money.oneCentCount + moneyToAdd.oneCentCount)
                .tenCentCount(money.tenCentCount + moneyToAdd.tenCentCount)
                .quarterCount(money.quarterCount + moneyToAdd.quarterCount)
                .oneDollarCount(money.oneDollarCount + moneyToAdd.oneDollarCount)
                .fiveDollarCount(money.fiveDollarCount + moneyToAdd.fiveDollarCount)
                .twentyDollarCount(money.twentyDollarCount + moneyToAdd.twentyDollarCount)
                .build();
    }
}
