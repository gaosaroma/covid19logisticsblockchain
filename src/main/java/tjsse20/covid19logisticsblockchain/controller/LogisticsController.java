package tjsse20.covid19logisticsblockchain.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.TransactionSuspensionNotSupportedException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tjsse20.covid19logisticsblockchain.entity.*;
import tjsse20.covid19logisticsblockchain.pojo.LogisticsInfo;
import tjsse20.covid19logisticsblockchain.pojo.OrderInfo;
import tjsse20.covid19logisticsblockchain.pojo.TimelineInfo;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.service.LogisticsService;
import tjsse20.covid19logisticsblockchain.service.RiskService;
import tjsse20.covid19logisticsblockchain.service.StationService;
import tjsse20.covid19logisticsblockchain.service.UserService;
import tjsse20.covid19logisticsblockchain.util.BlockUtil;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;
import tjsse20.covid19logisticsblockchain.util.RiskUtil;

import java.util.Collections;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logistics")
public class LogisticsController {

    @Autowired
    LogisticsService logisticsService;

    @Autowired
    StationService stationService;

    @Autowired
    RiskController riskController;

    @Autowired
    UserService userService;

    @Autowired
    RiskService riskService;

    @RequestMapping("/list")
    @ResponseBody
    public StandardResult list(@RequestBody User user) {
        /**
         * 获取该用户/工作人员所有物流信息（按时间排序）
         */
        List<LogisticsInfo> logistics = logisticsService.logisticsByUser(user);
        JSONArray result = new JSONArray();
        for (LogisticsInfo l : logistics) {
            if (l.getLeavingTime() != null) {
                continue;
            }
            JSONObject j = (JSONObject) JSONObject.toJSON(l);
            JSONArray ja = new JSONArray();
            JSONObject src = new JSONObject();
            src.put("name", l.getAddressor());
            src.put("city", l.getSrcCity());
            JSONObject dest = new JSONObject();
            dest.put("name", l.getRecipient());
            dest.put("city", l.getDestCity());
            ja.add(src);
            ja.add(dest);
            j.put("src_dest_list", ja);
            result.add(j);
        }
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @RequestMapping("/search")
    @ResponseBody
    public StandardResult search(@RequestBody Order order) {
        List<LogisticsInfo> logistics = logisticsService.logisticsByOrder(order);
        JSONArray result = new JSONArray();
        for (LogisticsInfo l : logistics) {
            if (l.getLeavingTime() != null) {
                continue;
            }
            JSONObject j = (JSONObject) JSONObject.toJSON(l);
            JSONArray ja = new JSONArray();
            JSONObject src = new JSONObject();
            src.put("name", l.getAddressor());
            src.put("city", l.getSrcCity());
            JSONObject dest = new JSONObject();
            dest.put("name", l.getRecipient());
            dest.put("city", l.getDestCity());
            ja.add(src);
            ja.add(dest);
            j.put("src_dest_list", ja);
            result.add(j);
        }
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @RequestMapping("/blockSearch")
    @ResponseBody
    public StandardResult blockSearch(@RequestBody Logistics logistics) {
        int id = logistics.getId();
        List<LogisticsInfo> logisticsList = logisticsService.getAllLogisticsByOrderId(logistics.getOrderId());
        LogisticsInfo logisticsInfo = logisticsList.get(logisticsList.size() - id - 1);
        JSONObject result = new JSONObject();
        result.put("time", logisticsInfo.getArrivingTime());
        result.put("cur_ware", logisticsInfo.getStationName());
        result.put("worker_name", logisticsInfo.getWorkerName());
        result.put("block_id", logisticsInfo.getRiskBlock());
        result.put("block_height", BlockUtil.getBlockHeight(""));
        result.put("risk", logisticsInfo.getRiskLevel());
        JSONArray ja = new JSONArray();
        JSONObject src = new JSONObject();
        src.put("city", logisticsInfo.getSrcCity());
        src.put("name", logisticsInfo.getAddressor());
        JSONObject dest = new JSONObject();
        dest.put("city", logisticsInfo.getDestCity());
        dest.put("name", logisticsInfo.getRecipient());
        ja.add(src);
        ja.add(dest);
        result.put("src_dest_list", ja);
        result.put("order_id", logisticsInfo.getOrderId());
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @RequestMapping("/select")
    @ResponseBody
    public StandardResult select(@RequestBody Order order) {
        List<TimelineInfo> timelineInfos = logisticsService.timelineByOrder(order);
        Collections.reverse(timelineInfos);
        List<LogisticsInfo> logistics = logisticsService.logisticsByOrder(order);
        List<OrderInfo> relatedOrder = logisticsService.getOrderById(order.getId());
        JSONObject orderInfo = requestBodyProcess(logistics).getJSONObject(0);
        JSONArray timeline = requestBodyProcess(timelineInfos);
        orderInfo.put("timeline", timeline);
        orderInfo.put("shop", JSONObject.toJSON(relatedOrder.get(0)));
        return new StandardResult(ConstantDefinition.REQUEST_OK, orderInfo);
    }

    private JSONArray requestBodyProcess(List o) {
        JSONArray array = new JSONArray();
        if (o.isEmpty()) {
            return new JSONArray();
        }
        if (o.get(0) instanceof LogisticsInfo) {
            for (Object i : o) {
                LogisticsInfo info = (LogisticsInfo) i;
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("logistics_id", info.getId());
                jsonObject.put("order_id", info.getOrderId());
                jsonObject.put("station_name", info.getStationName());
                JSONObject src = new JSONObject();
                src.put("city", info.getSrcCity());
                src.put("src_address", info.getSrcAddress());
                src.put("src_longitude", info.getSrcLongitude());
                src.put("src_latitude", info.getSrcLatitude());
                JSONObject dest = new JSONObject();
                dest.put("city", info.getDestCity());
                dest.put("dest_address", info.getDestAddress());
                dest.put("dest_longitude", info.getDestLongitude());
                dest.put("dest_latitude", info.getDestLatitude());
                JSONObject srcDest = new JSONObject();
                srcDest.put("src", src);
                srcDest.put("dest", dest);
                jsonObject.put("src_dest", srcDest);
                jsonObject.put("status", info.getStatus());
                jsonObject.put("curr_address", info.getStationName());
                jsonObject.put("arriving_time", info.getArrivingTime());
                jsonObject.put("leaving_time", info.getLeavingTime());
                jsonObject.put("risk", info.getRiskLevel());
                jsonObject.put("risk_block", info.getRiskBlock());
                array.add(jsonObject);
            }
        } else if (o.get(0) instanceof TimelineInfo) {
            Collections.reverse(o);
            for (int i = 0; i < o.size(); i++) {
                TimelineInfo info = (TimelineInfo) o.get(i);
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("status", info.getStatus());
                jsonObject.put("arriving_time", info.getArrivingTime());
                jsonObject.put("leaving_time", info.getLeavingTime());
                jsonObject.put("trans_node", info.getStationName());
                jsonObject.put("worker_name", info.getWorkerName());
                jsonObject.put("risk", info.getRisk());
                JSONArray ja = new JSONArray();
                if (info.getStationType().equals("仓库")) {
                    JSONObject j = new JSONObject();
                    j.put("longitude", info.getLongitude());
                    j.put("latitude", info.getLatitude());
                    ja.add(j);
                } else if (!info.getStationType().equals("仓库") && i != (o.size() - 1) && i != 0) {
                    JSONObject j = new JSONObject();
                    j.put("longitude", ((TimelineInfo) o.get(i - 1)).getLongitude());
                    j.put("latitude", ((TimelineInfo) o.get(i - 1)).getLatitude());
                    ja.add(j);
                    JSONObject j2 = new JSONObject();
                    j2.put("longitude", ((TimelineInfo) o.get(i + 1)).getLongitude());
                    j2.put("latitude", ((TimelineInfo) o.get(i + 1)).getLatitude());
                    ja.add(j2);
                }
                jsonObject.put("coordinate", ja);
                jsonObject.put("risk_block", info.getRiskBlock());
                jsonObject.put("station_type", info.getStationType().equals("仓库") ? 1 : 0);
                array.add(jsonObject);
            }
            Collections.reverse(o);
        }
        return array;
    }

    @ResponseBody
    @RequestMapping("/create")
    public StandardResult create(@RequestBody JSONObject request) {
        {
            RelatedPerson addressor = new RelatedPerson();
            RelatedPerson recipient = new RelatedPerson();
            Order order = new Order();
            order.setCommodity(request.getString("product_name"));

            addressor.setContactTel(request.getString("contact_s"));
            addressor.setName(request.getString("ship_name"));
            addressor.setProvince(request.getJSONObject("ship_address").getString("province"));
            addressor.setCity(request.getJSONObject("ship_address").getString("city"));
            addressor.setDistrict(request.getJSONObject("ship_address").getString("district"));
            addressor.setAddress(request.getString("ship_detail_address"));
            addressor.setLongitude(request.getJSONObject("ship_address").getFloat("longitude"));
            addressor.setLatitude(request.getJSONObject("ship_address").getFloat("latitude"));
            addressor.setRiskLevel(RiskUtil.getStaticRiskLevel(addressor.getProvince(), addressor.getCity(), addressor.getDistrict()));
            addressor = logisticsService.createRelatedPerson(addressor);

            recipient.setContactTel(request.getString("contact"));
            recipient.setName(request.getString("name"));
            recipient.setProvince(request.getJSONObject("receive_address").getString("province"));
            recipient.setCity(request.getJSONObject("receive_address").getString("city"));
            recipient.setDistrict(request.getJSONObject("receive_address").getString("district"));
            recipient.setLongitude(request.getJSONObject("receive_address").getFloat("longitude"));
            recipient.setLatitude(request.getJSONObject("receive_address").getFloat("latitude"));
            recipient.setRiskLevel(RiskUtil.getStaticRiskLevel(recipient.getProvince(), recipient.getCity(), recipient.getDistrict()));
            recipient.setAddress(request.getString("receive_detail_address"));
            recipient = logisticsService.createRelatedPerson(recipient);

            User user = userService.getUserByTel(recipient.getContactPerson(), 0);
            if (user == null) {
                user = new User();
                user.setTelephone(recipient.getContactTel());
                user.setType(2);
                user.setUsername(recipient.getName());
                user.setStatus(ConstantDefinition.USER_STATUS_AVAILABLE);
                user.setPasswd("21232f297a57a5a743894a0e4a801fc3");
                userService.insert(user);
            }
            user = userService.getUserByTel(addressor.getContactTel(), 0);

            order.setAddressorId(addressor.getId());
            order.setRecipientId(recipient.getId());
            logisticsService.createOrder(order);
            JSONArray result = new JSONArray();
            result.add(addressor);
            result.add(recipient);
            result.add(order);

            Logistics logistics = new Logistics();
            logistics.setStationId(1);
            logistics.setArrivingTime(new Date());
            logistics.setSubmiter(user.getId());
            logistics.setRiskLevel(RiskUtil.getStaticRiskLevel(addressor.getProvince(), addressor.getCity(), addressor.getDistrict()));
            logistics.setOrderId(order.getId());
            logisticsService.createLogistics(logistics);
            logisticsService.createLogisticsBlock(logistics);
            return new StandardResult(ConstantDefinition.REQUEST_OK, result);
        }
    }

    @ResponseBody
    @RequestMapping("/createOrder")
    public StandardResult createOrder(@RequestBody Order order) {
        order = logisticsService.createOrder(order);
        return new StandardResult(ConstantDefinition.REQUEST_OK, order);
    }

    @ResponseBody
    @RequestMapping("/createLogistics")
    public StandardResult createLogistics(@RequestBody Logistics logistics) {
        TransferStation station = stationService.getById(logistics.getStationId());
        logistics.setRiskLevel(RiskUtil.getStaticRiskLevel(station.getProvince(), station.getCity(), station.getDistrict()));
        logistics = logisticsService.createLogistics(logistics);
        logistics = logisticsService.createLogisticsBlock(logistics);
        return new StandardResult(ConstantDefinition.REQUEST_OK, logistics);
    }

    @ResponseBody
    @RequestMapping("/createPerson")
    public StandardResult createPerson(@RequestBody RelatedPerson relatedPerson) {
        relatedPerson = logisticsService.createRelatedPerson(relatedPerson);
        return new StandardResult(ConstantDefinition.REQUEST_OK, relatedPerson);
    }

    @ResponseBody
    @RequestMapping("/compare")
    public StandardResult compare(@RequestBody Logistics logistics) {
        int id = logistics.getId();
        List<LogisticsInfo> logisticsList = logisticsService.getAllLogisticsByOrderId(logistics.getOrderId());
        List<LogisticsInfo> logisticsBlockList = logisticsService.getAllLogisticsFromBlockByOrderId(logistics.getOrderId());
        LogisticsInfo logisticsInfo;
        if (logisticsList.size() - id - 1 < 0 || logisticsList.size() - id - 1 >= logisticsList.size()){
            logisticsInfo = logisticsList.get(0);
        }else {
            logisticsInfo = logisticsList.get(logisticsList.size() - id - 1);
        }
        JSONArray result = new JSONArray();

        JSONObject l1 = new JSONObject();
        l1.put("orderId", logistics.getOrderId());
        l1.put("time", logisticsInfo.getArrivingTime());
        l1.put("snapshotIdx", id);
        TransferStation station = stationService.getById(logisticsInfo.getStationId());
//        l1.put("cur_ware", station.getAddress());
        l1.put("cur_ware", station.getName());
        l1.put("worker_name", logisticsInfo.getWorkerName());
        l1.put("risk", logisticsInfo.getRiskLevel());
        l1.put("block_hash", logisticsInfo.getRiskBlock());
        l1.put("block_height", 1);
        l1.put("from_block", 0);

        if (logisticsList.size() - id - 1 < 0 || logisticsList.size() - id - 1 >= logisticsList.size()){
            logisticsInfo = logisticsList.get(0);
        }else {
            logisticsInfo = logisticsList.get(logisticsList.size() - id - 1);
        }
        JSONObject l2 = new JSONObject();
        l2.put("orderId", logistics.getOrderId());
        l2.put("time", logisticsInfo.getArrivingTime());
        l2.put("snapshotIdx", id);
        station = stationService.getById(logisticsInfo.getStationId());
        l2.put("cur_ware", station.getName());
        l2.put("worker_name", logisticsInfo.getWorkerName());
        l2.put("risk", logisticsInfo.getRiskLevel());
        l2.put("block_hash", logisticsInfo.getRiskBlock());
        l2.put("block_height", 1);
        l2.put("from_block", 1);

        JSONObject l3 = new JSONObject();
        l3.put("isSame", 1);
        if (!l1.getInteger("risk").equals(l2.getInteger("risk"))) {
            l3.put("isSame", 0);
        }
        result.add(l1);
        result.add(l2);
        result.add(l3);
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @ResponseBody
    @RequestMapping("test")
    public StandardResult test(@RequestBody JSONObject request) {
        return new StandardResult(ConstantDefinition.REQUEST_OK, request);
    }

    @ResponseBody
    @RequestMapping("/byStation")
    public StandardResult wareLogisticsList(@RequestBody JSONObject request) {
        int workerId = request.getInteger("worker_id");
        TransferStation transferStation = stationService.getStationByWorker(workerId);
        List<LogisticsInfo> logisticsInfos = logisticsService.getByStation(transferStation.getId());
        JSONArray result = new JSONArray();
        for (LogisticsInfo l : logisticsInfos) {
            JSONObject j = (JSONObject) JSONObject.toJSON(l);
            JSONArray ja = new JSONArray();
            JSONObject src = new JSONObject();
            src.put("name", l.getAddressor());
            src.put("city", l.getSrcCity());
            JSONObject dest = new JSONObject();
            dest.put("name", l.getRecipient());
            dest.put("city", l.getDestCity());
            ja.add(src);
            ja.add(dest);
            j.put("src_dest_list", ja);
            result.add(j);
        }
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @ResponseBody
    @RequestMapping("/supplier")
    public StandardResult supplier(@RequestBody JSONObject request) {
        Integer id = request.getInteger("id");
        List<LogisticsInfo> logisticsInfos = logisticsService.selectBySupplier(id);
        JSONArray result = new JSONArray();
        for (LogisticsInfo l : logisticsInfos) {
            JSONObject j = (JSONObject) JSONObject.toJSON(l);
            JSONArray ja = new JSONArray();
            JSONObject src = new JSONObject();
            src.put("name", l.getAddressor());
            src.put("city", l.getSrcCity());
            JSONObject dest = new JSONObject();
            dest.put("name", l.getRecipient());
            dest.put("city", l.getDestCity());
            ja.add(src);
            ja.add(dest);
            j.put("src_dest_list", ja);
            result.add(j);
        }
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @ResponseBody
    @RequestMapping("/normalUser")
    public StandardResult user(@RequestBody JSONObject request) {
        Integer id = request.getInteger("id");
        List<LogisticsInfo> logisticsInfos = logisticsService.selectByUser(id);
        JSONArray result = new JSONArray();
        for (LogisticsInfo l : logisticsInfos) {
            JSONObject j = (JSONObject) JSONObject.toJSON(l);
            JSONArray ja = new JSONArray();
            JSONObject src = new JSONObject();
            src.put("name", l.getAddressor());
            src.put("city", l.getSrcCity());
            JSONObject dest = new JSONObject();
            dest.put("name", l.getRecipient());
            dest.put("city", l.getDestCity());
            ja.add(src);
            ja.add(dest);
            j.put("src_dest_list", ja);
            result.add(j);
        }
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @ResponseBody
    @RequestMapping("/isSame")
    public StandardResult isSame() {
        List<Logistics> logisticsList = logisticsService.getAll();
        StandardResult standardResult = new StandardResult();
        for (Logistics logistics : logisticsList) {
            StandardResult result = compare(logistics);
            int isSameResult = result.getResultObjects().getJSONObject(2).getInteger("isSame");
            if (isSameResult == 0) {
                System.out.println("这条数据不一样：");
                System.out.println(logistics.toString());
                JSONObject isSameObject = new JSONObject();
                isSameObject.put("isSame", 0);
                standardResult.addObject(isSameObject);
                return standardResult;
            }
        }

        List<RiskSubmit> riskSubmitList = riskService.getAll();
        for (RiskSubmit riskSubmit : riskSubmitList) {
            JSONObject request = new JSONObject();
            request.put("id", riskSubmit.getId());
            StandardResult result = riskController.compare(request);
            int isSameResult = 1;
            try {
                isSameResult = result.getResultObjects().getJSONObject(2).getInteger("isSame");
            } catch (IndexOutOfBoundsException e){
                System.out.println(riskSubmit.toString());
            }
            if (isSameResult == 0) {
                System.out.println("这条数据不一样：");
                System.out.println(riskSubmit.toString());
                JSONObject isSameObject = new JSONObject();
                isSameObject.put("isSame", 0);
                standardResult.addObject(isSameObject);
                return standardResult;
            }
        }
        JSONObject isSameObject = new JSONObject();
        isSameObject.put("isSame", 1);
        standardResult.addObject(isSameObject);
        return standardResult;
    }

}