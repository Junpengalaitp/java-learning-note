package pluralsight.ddd.practice.mapping;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import pluralsight.ddd.practice.entity.Snack;

/**
 * @author Junpeng He
 */
@TableName("learn.snack")
@NoArgsConstructor
@Data
public class SnackMapping {
    private String id;
    private String name;

    public SnackMapping(Snack snack) {
        this.id = snack.getId();
        this.name = snack.getName();
    }
}
