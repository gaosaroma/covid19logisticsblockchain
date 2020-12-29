package tjsse20.covid19logisticsblockchain.mapper;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import sun.rmi.runtime.Log;
import tjsse20.covid19logisticsblockchain.entity.Logistics;
import tjsse20.covid19logisticsblockchain.entity.Order;
import tjsse20.covid19logisticsblockchain.entity.RelatedPerson;
import tjsse20.covid19logisticsblockchain.pojo.LogisticsInfo;
import tjsse20.covid19logisticsblockchain.pojo.TimelineInfo;

import java.util.Date;
import java.util.List;

@Repository
public interface LogisticsMapper {

    List<LogisticsInfo> selectByUserId(int userId);

    List<LogisticsInfo> selectByOrderId(int orderId);

    List<TimelineInfo> selectTimeLineByOrderId(int orderId);

    List<Logistics> selectLogisticsByOrder(int orderId);
    void updateRisk(int stationId, int risk);
    void insertOrder(Order order);
    void insertLogistics(Logistics logistics);
//    void updateLogisticsArrivingTime(Logistics logistics);
    void updateLogisticsArrivingTime(@Param("leavingTime") Date leavingTime,
                                     @Param("status") int status,
                                     @Param("id") int id);
    void insertRelatedPerson(RelatedPerson relatedPerson);
}
