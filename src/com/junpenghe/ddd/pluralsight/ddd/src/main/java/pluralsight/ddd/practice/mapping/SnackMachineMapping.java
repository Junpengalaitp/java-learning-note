package pluralsight.ddd.practice.mapping;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import pluralsight.ddd.practice.entity.SnackMachine;

import java.io.Serializable;


@TableName("learn.snack_machine")
@NoArgsConstructor
@Data
public class SnackMachineMapping implements Serializable {
    private static final long serialVersionUID = 8276900298636623443L;

    private String id;

    private Integer oneCentCount;

    private Integer tenCentCount;

    private Integer quarterCount;

    private Integer oneDollarCount;

    private Integer fiveDollarCount;

    private Integer twentyDollarCount;

    public SnackMachineMapping(SnackMachine snackMachine) {
        this.id = snackMachine.getId();
        this.oneCentCount = snackMachine.getMoneyInside().getOneCentCount();
        this.tenCentCount = snackMachine.getMoneyInside().getTenCentCount();
        this.quarterCount = snackMachine.getMoneyInside().getQuarterCount();
        this.oneDollarCount = snackMachine.getMoneyInside().getOneDollarCount();
        this.fiveDollarCount = snackMachine.getMoneyInside().getFiveDollarCount();
        this.twentyDollarCount = snackMachine.getMoneyInside().getTwentyDollarCount();
    }
}