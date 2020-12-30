package pluralsight.ddd.practice.atm.repository;

import org.springframework.beans.factory.annotation.Autowired;
import pluralsight.ddd.practice.atm.dao.AtmDao;
import pluralsight.ddd.practice.atm.mapping.AtmMapping;
import pluralsight.ddd.practice.repository.Repository;

/**
 * @author Junpeng He
 */
@org.springframework.stereotype.Repository
public class AtmRepository implements Repository<AtmMapping> {

    @Autowired
    private AtmDao atmDao;

    @Override
    public AtmMapping getById(String id) {
        return null;
    }

    @Override
    public int save(AtmMapping atmMapping) {
        return atmDao.insert(atmMapping);
    }
}
