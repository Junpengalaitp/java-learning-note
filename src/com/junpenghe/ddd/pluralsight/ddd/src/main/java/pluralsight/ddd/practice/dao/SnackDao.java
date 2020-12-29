package pluralsight.ddd.practice.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;
import pluralsight.ddd.practice.mapping.SnackMapping;

@Repository
public interface SnackDao extends BaseMapper<SnackMapping> {
}