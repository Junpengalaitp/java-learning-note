package pluralsight.ddd.practice.model;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@TableName("learn.snack_machine")
@Builder
@Data
public class SnackMachineModel implements Serializable {
    private static final long serialVersionUID = 8276900298636623443L;

    private String id;

    private Integer oneCentCount;

    private Integer tenCentCount;

    private Integer quarterCount;

    private Integer oneDollarCount;

    private Integer fiveDollarCount;

    private Integer twentyDollarCount;
}