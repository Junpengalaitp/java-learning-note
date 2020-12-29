package pluralsight.ddd.practice.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pluralsight.ddd.practice.dao.SlotDao;
import pluralsight.ddd.practice.dao.SnackDao;
import pluralsight.ddd.practice.dao.SnackMachineDao;
import pluralsight.ddd.practice.entity.SnackMachine;
import pluralsight.ddd.practice.mapping.SlotMapping;
import pluralsight.ddd.practice.mapping.SnackMachineMapping;
import pluralsight.ddd.practice.mapping.SnackMapping;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Junpeng He
 */
@org.springframework.stereotype.Repository
public class SnackMachineRepository implements Repository<SnackMachine> {

    @Autowired
    private SnackMachineDao snackMachineDao;
    @Autowired
    private SnackDao snackDao;
    @Autowired
    private SlotDao slotDao;

    @Override
    public SnackMachine getById(String id) {
        return null;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int save(SnackMachine snackMachine) {
        try {
            SnackMachineMapping snackMachineMapping = new SnackMachineMapping(snackMachine);
            List<SlotMapping> slotMappings = snackMachine.getSlots().stream()
                    .filter(s -> s.getSnackPile().getSnack() != null)
                    .map(SlotMapping::new)
                    .collect(Collectors.toList());
            List<SnackMapping> snackMappings = snackMachine.getSlots().stream()
                    .filter(s -> s.getSnackPile().getSnack() != null)
                    .map(s -> s.getSnackPile().getSnack()).map(SnackMapping::new)
                    .collect(Collectors.toList());
            snackMachineDao.insert(snackMachineMapping);
            slotMappings.forEach(s -> slotDao.insert(s));
            snackMappings.forEach(s -> snackDao.insert(s));
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }
}
