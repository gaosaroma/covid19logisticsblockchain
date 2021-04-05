package tjsse20.covid19logisticsblockchain.mapper;

import org.springframework.stereotype.Repository;
import tjsse20.covid19logisticsblockchain.entity.RiskSubmit;
import tjsse20.covid19logisticsblockchain.pojo.RiskInfo;

import java.util.List;

@Repository
public interface RiskBlockMapper {
    RiskInfo select(int id);
    List<RiskInfo> selectRiskByStatus(int status);
    List<RiskInfo> selectRiskBySubmitter(int submitterId);
    List<RiskInfo> selectAllRisks();

    void insert(RiskSubmit riskSubmit);
    void updateStatus(RiskSubmit riskSubmit);
}
