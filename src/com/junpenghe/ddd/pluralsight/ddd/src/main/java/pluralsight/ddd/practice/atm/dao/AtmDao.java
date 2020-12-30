package pluralsight.ddd.practice.atm.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import pluralsight.ddd.practice.atm.mapping.AtmMapping;

/**
 * @author Junpeng He
 */
@Repository
public interface AtmDao extends BaseMapper<AtmMapping> {
}
