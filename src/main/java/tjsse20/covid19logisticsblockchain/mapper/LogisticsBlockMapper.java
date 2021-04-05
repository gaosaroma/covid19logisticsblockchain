package tjsse20.covid19logisticsblockchain.mapper;

import org.apache.ibatis.annotations.Param;
import tjsse20.covid19logisticsblockchain.entity.Logistics;
import tjsse20.covid19logisticsblockchain.entity.Order;
import tjsse20.covid19logisticsblockchain.entity.RelatedPerson;
import tjsse20.covid19logisticsblockchain.pojo.LogisticsInfo;
import tjsse20.covid19logisticsblockchain.pojo.OrderInfo;
import tjsse20.covid19logisticsblockchain.pojo.TimelineInfo;

import java.util.Date;
import java.util.List;

public interface LogisticsBlockMapper {

    List<LogisticsInfo> selectByUserId(int userId);

    List<LogisticsInfo> selectByOrderId(int orderId);

    List<LogisticsInfo> selectAllByOrderId(int orderId);

    List<TimelineInfo> selectTimeLineByOrderId(int orderId);

    List<OrderInfo> selectOrderById(int id);

    List<LogisticsInfo> selectByStation(int stationId);

    List<Logistics> selectLogisticsByOrder(int orderId);
    void updateRisk(int stationId, int risk);
    void insertOrder(Order order);
    void insertLogistics(Logistics logistics);
    //    void updateLogisticsArrivingTime(Logistics logistics);
    void updateLogisticsArrivingTime(@Param("leavingTime") Date leavingTime,
                                     @Param("status") int status,
                                     @Param("id") int id);
    void insertRelatedPerson(RelatedPerson relatedPerson);
    List<LogisticsInfo> selectBySupplier(Integer id);
    List<LogisticsInfo> selectByUser(Integer id);
    Logistics selectById(Integer id);
}
