package pluralsight.ddd.practice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import pluralsight.ddd.practice.mapping.SlotMapping;

@Repository
public interface SlotDao extends BaseMapper<SlotMapping> {
}