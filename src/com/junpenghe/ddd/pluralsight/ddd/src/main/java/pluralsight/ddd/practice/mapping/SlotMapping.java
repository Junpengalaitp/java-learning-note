package pluralsight.ddd.practice.mapping;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.NoArgsConstructor;
import pluralsight.ddd.practice.entity.Slot;

/**
 * @author Junpeng He
 */
@TableName("learn.slot")
@NoArgsConstructor
@Data
public class SlotMapping {
    private String id;
    private int quantity;
    private double price;
    private int position;
    private String snackMachineId;
    private String snackId;

    public SlotMapping(Slot slot) {
        this.id = slot.getId();
        this.quantity = slot.getSnackPile().getQuantity();
        this.price = slot.getSnackPile().getPrice();
        this.position = slot.getPosition();
        this.snackMachineId = slot.getSnackMachine().getId();
        this.snackId = slot.getSnackPile().getSnack().getId();
    }
}
