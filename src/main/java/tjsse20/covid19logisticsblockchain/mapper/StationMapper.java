package tjsse20.covid19logisticsblockchain.mapper;

import org.springframework.stereotype.Repository;
import tjsse20.covid19logisticsblockchain.entity.TransferStation;

import java.util.List;

@Repository
public interface StationMapper {
    TransferStation select(Integer id);
    List<TransferStation> getAll();
    List<TransferStation> selectByType(String type);
    void updateRisk(int stationId, int risk);
    void insert(TransferStation station);
    void update(TransferStation station);
    TransferStation selectByWorker(int workerId);
}
