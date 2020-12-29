package pluralsight.ddd.practice.dao;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;
import pluralsight.ddd.practice.entity.SnackMachine;
import pluralsight.ddd.practice.mapping.SnackMachineMapping;
import pluralsight.ddd.practice.value.object.Money;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class SnackMachineDaoTest {

    @Autowired
    private SnackMachineDao snackMachineDao;

    @Transactional
    @Test
    void testInsertOne() {
        SnackMachine snackMachine = new SnackMachine();
        snackMachine.insertMoney(Money.DOLLAR);
        int res = snackMachineDao.insert(new SnackMachineMapping(snackMachine));
        assertEquals(1, res);
    }

    @Test
    void testSelectOne() {
        String id = "91090148-2892-48bf-a59e-159ddb28b551";
        SnackMachineMapping machineMapping = snackMachineDao.selectById(id);
        assertEquals(id, machineMapping.getId());
    }
}