package tjsse20.covid19logisticsblockchain.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import javafx.animation.Timeline;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tjsse20.covid19logisticsblockchain.entity.Logistics;
import tjsse20.covid19logisticsblockchain.entity.Order;
import tjsse20.covid19logisticsblockchain.entity.RelatedPerson;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.pojo.LogisticsInfo;
import tjsse20.covid19logisticsblockchain.pojo.TimelineInfo;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.service.LogisticsService;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;

import java.util.List;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    @Autowired
    LogisticsService logisticsService;

    @RequestMapping("/list")
    @ResponseBody
    public StandardResult list(@RequestBody User user) {
        /**
         * 获取该用户/工作人员所有物流信息（按时间排序）
         */
        List<LogisticsInfo> logistics = logisticsService.logisticsByUser(user);
        return new StandardResult(ConstantDefinition.REQUEST_OK, requestBodyProcess(logistics));
    }

    @RequestMapping("/search")
    @ResponseBody
    public StandardResult search(@RequestBody Order order) {
        List<LogisticsInfo> logistics = logisticsService.logisticsByOrder(order);
        return new StandardResult(ConstantDefinition.REQUEST_OK, requestBodyProcess(logistics));
    }

    @RequestMapping("/select")
    @ResponseBody
    public StandardResult select(@RequestBody Order order) {
        List<TimelineInfo> timelineInfos = logisticsService.timelineByOrder(order);
        List<LogisticsInfo> logistics = logisticsService.logisticsByOrder(order);
        JSONObject orderInfo = requestBodyProcess(logistics).getJSONObject(0);
        JSONArray timeline = requestBodyProcess(timelineInfos);
        orderInfo.put("timeline", timeline);
        return new StandardResult(ConstantDefinition.REQUEST_OK, orderInfo);
    }

    private JSONArray requestBodyProcess(List o) {
        JSONArray array = new JSONArray();
        if (o.get(0) instanceof LogisticsInfo){
            for (Object i : o) {
                LogisticsInfo info = (LogisticsInfo) i;
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("logistics_id", info.getId());
                jsonObject.put("order_id", info.getLogisticsNumber());
                jsonObject.put("station_name", info.getStationName());
                JSONObject src = new JSONObject();
                src.put("addressor", info.getAddressor());
                src.put("src_address", info.getSrcAddress());
                src.put("src_longitude", info.getSrcLongitude());
                src.put("src_latitude", info.getSrcLatitude());
                JSONObject dest = new JSONObject();
                dest.put("recipient", info.getRecipient());
                dest.put("dest_address", info.getDestAddress());
                dest.put("dest_longitude", info.getDestLongitude());
                dest.put("dest_latitude", info.getDestLatitude());
                JSONObject srcDest = new JSONObject();
                srcDest.put("src", src);
                srcDest.put("dest", dest);
                jsonObject.put("src_dest", srcDest);
                jsonObject.put("status", info.getStatus());
                jsonObject.put("curr_address", info.getCurrAddress());
                jsonObject.put("arriving_time", info.getArrivingTime());
                jsonObject.put("leaving_time", info.getLeavingTime());
                jsonObject.put("risk", info.getRiskLevel());
                array.add(jsonObject);
            }
        }
        else if (o.get(0) instanceof TimelineInfo){
            for (Object i : o) {
                TimelineInfo info = (TimelineInfo) i;
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", info.getStatus());
                jsonObject.put("arriving_time", info.getArrivingTime());
                jsonObject.put("leaving_time", info.getLeavingTime());
                jsonObject.put("trans_node", info.getStationName());
                jsonObject.put("worker_name", info.getWorkerName());
                jsonObject.put("risk", info.getRisk());
                jsonObject.put("longitude", info.getLongitude());
                jsonObject.put("latitude", info.getLatitude());
                array.add(jsonObject);
            }
        }
        return array;
    }

    @ResponseBody
    @RequestMapping("/createOrder")
    public StandardResult createOrder(@RequestBody Order order){
        order = logisticsService.createOrder(order);
        return new StandardResult(ConstantDefinition.REQUEST_OK, order);
    }

    @ResponseBody
    @RequestMapping("/createLogistics")
    public StandardResult createLogistics(@RequestBody Logistics logistics){
        logistics = logisticsService.createLogistics(logistics);
        return new StandardResult(ConstantDefinition.REQUEST_OK, logistics);
    }

    @ResponseBody
    @RequestMapping("/createPerson")
    public StandardResult createPerson(@RequestBody RelatedPerson relatedPerson){
        relatedPerson = logisticsService.createRelatedPerson(relatedPerson);
        return new StandardResult(ConstantDefinition.REQUEST_OK, relatedPerson);
    }

}