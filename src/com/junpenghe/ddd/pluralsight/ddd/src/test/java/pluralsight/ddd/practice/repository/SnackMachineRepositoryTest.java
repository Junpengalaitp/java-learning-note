package pluralsight.ddd.practice.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pluralsight.ddd.practice.entity.Snack;
import pluralsight.ddd.practice.entity.SnackMachine;
import pluralsight.ddd.practice.value.object.Money;
import pluralsight.ddd.practice.value.object.SnackPile;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @author Junpeng He
 */
@SpringBootTest
@ExtendWith(SpringExtension.class)
class SnackMachineRepositoryTest {

    @Autowired
    private SnackMachineRepository snackMachineRepository;

    @Test
    void getById() {
    }

    @Test
    void save() {
        SnackMachine snackMachine = new SnackMachine();
        snackMachine.loadMoney(Money.FIVE_DOLLAR);
        snackMachine.loadSnacks(1, new SnackPile(new Snack("Some snack"), 10, 1.0));
        assertTrue(snackMachineRepository.save(snackMachine) > 0);
    }
}