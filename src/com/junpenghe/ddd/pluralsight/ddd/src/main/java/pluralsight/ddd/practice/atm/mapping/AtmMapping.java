package pluralsight.ddd.practice.atm.mapping;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import pluralsight.ddd.practice.atm.Atm;

/**
 * @author Junpeng He
 */
@TableName("learn.slot")
@NoArgsConstructor
@Data
public class AtmMapping {
    private String id;
    private Double moneyCharged;
    private Integer oneCentCount;
    private Integer tenCentCount;
    private Integer quarterCount;
    private Integer oneDollarCount;
    private Integer fiveDollarCount;
    private Integer twentyDollarCount;

    public AtmMapping(Atm atm) {
        this.id = atm.getId();
        this.moneyCharged = atm.getMoneyCharged().doubleValue();
        this.oneCentCount = atm.getMoneyInside().getOneCentCount();
        this.tenCentCount = atm.getMoneyInside().getTenCentCount();
        this.quarterCount = atm.getMoneyInside().getQuarterCount();
        this.oneDollarCount = atm.getMoneyInside().getOneDollarCount();
        this.fiveDollarCount = atm.getMoneyInside().getFiveDollarCount();
        this.twentyDollarCount = atm.getMoneyInside().getTwentyDollarCount();
    }
}
