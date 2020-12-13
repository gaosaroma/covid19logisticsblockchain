package tjsse20.covid19logisticsblockchain.mapper;

import org.springframework.stereotype.Repository;
import tjsse20.covid19logisticsblockchain.entity.TransferStation;

import java.util.List;

@Repository
public interface StationMapper {
    List<TransferStation> getAll();
}
