package pluralsight.ddd.practice.atm;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.SneakyThrows;
import pluralsight.ddd.practice.aggregate.AggregateRoot;
import pluralsight.ddd.practice.value.object.Money;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Atm extends AggregateRoot {
    private static final BigDecimal COMMISSION_RATE = BigDecimal.valueOf(0.01);

    private Money moneyInside;
    private BigDecimal moneyCharged;

    public Atm() {
        moneyInside = Money.NONE;
        moneyCharged = BigDecimal.ZERO;
    }

    @SneakyThrows
    public void takeMoney(double amount) {
        if (!StringUtils.EMPTY.equals(canTakeMoney(amount))) {
            throw new IllegalAccessException();
        }
        Money output = moneyInside.allocate(BigDecimal.valueOf(amount));
        moneyInside = moneyInside.subtract(output);
        BigDecimal amountWithCommission = calculateAmountWithCommission(amount);
        moneyCharged = moneyCharged.add(amountWithCommission);
    }

    public void loadMoney(Money money) {
        moneyInside = moneyInside.add(money);
    }

    public String canTakeMoney(double amount) {
        if (amount <= 0) {
            return "Invalid amount";
        }
        if (moneyInside.amount() < amount) {
            return "Not enough money";
        }
        return StringUtils.EMPTY;
    }

    private BigDecimal calculateAmountWithCommission(double amount) {
        BigDecimal commission = BigDecimal.valueOf(amount).multiply(COMMISSION_RATE);
        BigDecimal lessThanCent = commission.remainder(BigDecimal.valueOf(0.01));
        if (lessThanCent.signum() > 0) {
            commission = commission.subtract(lessThanCent).add(BigDecimal.valueOf(0.01));
        }
        return BigDecimal.valueOf(amount).add(commission);
    }
}
