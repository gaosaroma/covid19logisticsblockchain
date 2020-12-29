package tjsse20.covid19logisticsblockchain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tjsse20.covid19logisticsblockchain.entity.Logistics;
import tjsse20.covid19logisticsblockchain.entity.Order;
import tjsse20.covid19logisticsblockchain.entity.RelatedPerson;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.mapper.LogisticsMapper;
import tjsse20.covid19logisticsblockchain.pojo.LogisticsInfo;
import tjsse20.covid19logisticsblockchain.pojo.OrderInfo;
import tjsse20.covid19logisticsblockchain.pojo.TimelineInfo;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;

import java.util.Date;
import java.util.List;

@Service
public class LogisticsService {

    @Autowired
    LogisticsMapper logisticsMapper;

    public List<LogisticsInfo> logisticsByUser(User user){
        return logisticsMapper.selectByUserId(user.getId());
    }

    public List<LogisticsInfo> logisticsByOrder(Order order){
        return logisticsMapper.selectByOrderId(order.getId());
    }

    public List<TimelineInfo> timelineByOrder(Order order){
        return logisticsMapper.selectTimeLineByOrderId(order.getId());
    }

    public Order createOrder(Order order){
        order.setOrderTime(new Date());
        logisticsMapper.insertOrder(order);
        return order;
    }

    public Logistics createLogistics(Logistics logistics){
        List<Logistics> logisticsList = logisticsMapper.selectLogisticsByOrder(logistics.getOrderId());
        Date leavingTime = new Date();
        if (!logisticsList.isEmpty()){
            logisticsList.get(0).setStatus(ConstantDefinition.LOGISTICS_FINISHED);
            logisticsList.get(0).setLeavingTime(leavingTime);
            logisticsMapper.updateLogisticsArrivingTime(leavingTime,
                    logisticsList.get(0).getStatus(),
                    logisticsList.get(0).getId());
        }
        logistics.setArrivingTime(leavingTime);
        logistics.setStatus(ConstantDefinition.LOGISTICS_ONGOING);
        logisticsMapper.insertLogistics(logistics);
        return logistics;
    }

    public RelatedPerson createRelatedPerson(RelatedPerson relatedPerson){
        logisticsMapper.insertRelatedPerson(relatedPerson);
        return relatedPerson;
    }

    public List<OrderInfo> getOrderById(int id){
        return logisticsMapper.selectOrderById(id);
    }

}
