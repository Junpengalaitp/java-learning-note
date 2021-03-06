package pluralsight.ddd.practice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import pluralsight.ddd.practice.mapping.SnackMachineMapping;

@Repository
public interface SnackMachineDao extends BaseMapper<SnackMachineMapping> {
}