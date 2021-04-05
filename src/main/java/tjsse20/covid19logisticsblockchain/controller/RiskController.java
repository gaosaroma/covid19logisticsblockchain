package tjsse20.covid19logisticsblockchain.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import tjsse20.covid19logisticsblockchain.entity.Order;
import tjsse20.covid19logisticsblockchain.entity.RiskSubmit;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.pojo.LogisticsInfo;
import tjsse20.covid19logisticsblockchain.pojo.RiskInfo;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.service.LogisticsService;
import tjsse20.covid19logisticsblockchain.service.RiskService;
import tjsse20.covid19logisticsblockchain.util.BlockUtil;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;
import tjsse20.covid19logisticsblockchain.util.RiskUtil;

import java.util.List;

@RestController
@RequestMapping("/apply")
public class RiskController {

    @Autowired
    RiskService riskService;

    @Autowired
    LogisticsService logisticsService;

    @ResponseBody
    @RequestMapping("/getById")
    public StandardResult getById(@RequestBody RiskInfo riskInfo){
        RiskInfo newRisk = riskService.getById(riskInfo.getId());
        if (newRisk.getApplyType() == 2){
            Order order = new Order();
            order.setId(newRisk.getOrderId());
            List<LogisticsInfo> logistics = logisticsService.logisticsByOrder(order);
            LogisticsInfo logisticsInfo = logistics.get(0);
            newRisk.setRiskType(logisticsInfo.getRiskLevel());
        }
        return new StandardResult(ConstantDefinition.REQUEST_OK, newRisk);
    }

    @ResponseBody
    @RequestMapping("/all")
    public StandardResult all(@RequestBody User user){
        /**
         * 所有申请
         */
        List<RiskInfo> riskInfos = riskService.getAllApplies();
        return new StandardResult(ConstantDefinition.REQUEST_OK, riskInfos);
    }

    @ResponseBody
    @RequestMapping("/pending")
    public StandardResult pending(@RequestBody User user){
        /**
         * 待处理的申请
         */
        List<RiskInfo> riskInfos = riskService.getAppliesByStatus(0);
        JSONArray riskApply = new JSONArray();
        JSONArray riskCancel = new JSONArray();
        for (RiskInfo r : riskInfos){
            if (r.getApplyType() == ConstantDefinition.RISK_APPLY) {
                riskApply.add(r);
            }else if (r.getApplyType() == ConstantDefinition.RISK_CANCEL){
                Order order = new Order();
                order.setId(r.getOrderId());
                List<LogisticsInfo> logisticsInfos = logisticsService.logisticsByOrder(order);
                r.setRiskType(logisticsInfos.get(0).getRiskLevel());
                riskCancel.add(r);
            }
        }
        JSONArray result = new JSONArray();
        result.add(riskApply);
        result.add(riskCancel);
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @ResponseBody
    @RequestMapping("/bySubmitter")
    public StandardResult bySubmitter(@RequestBody User user){
        List<RiskInfo> riskInfos = riskService.getAppliesBySubmitter(user.getId());
        JSONArray riskApply = new JSONArray();
        JSONArray riskCancel = new JSONArray();
        for (RiskInfo r : riskInfos){
            if (r.getApplyType() == ConstantDefinition.RISK_APPLY) {
                riskApply.add(r);
            }else if (r.getApplyType() == ConstantDefinition.RISK_CANCEL){
                Order order = new Order();
                order.setId(r.getOrderId());
                List<LogisticsInfo> logisticsInfos = logisticsService.logisticsByOrder(order);
                r.setRiskType(logisticsInfos.get(0).getRiskLevel());
                riskCancel.add(r);
            }
        }
        JSONArray result = new JSONArray();
        result.add(riskApply);
        result.add(riskCancel);
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @ResponseBody
    @RequestMapping("/submitRisk")
    public StandardResult submitRisk(@RequestBody RiskSubmit riskSubmit){
        Order order = new Order();
        order.setId(riskSubmit.getLogisticsId());
        List<LogisticsInfo> logistics = logisticsService.logisticsByOrder(order);
        LogisticsInfo logisticsInfo = logistics.get(0);
        riskSubmit.setLogisticsId(logisticsInfo.getId());
        riskSubmit.setStationId(logisticsInfo.getStationId());
        riskSubmit.setRiskBlock(String.valueOf(BlockUtil.getBlockId()));
        riskService.submitApply(riskSubmit);
        return new StandardResult(ConstantDefinition.REQUEST_OK, riskSubmit);
    }

    @ResponseBody
    @RequestMapping("/agree")
    public StandardResult agree(@RequestBody RiskSubmit riskSubmit){
        riskService.agreeApply(riskSubmit);
        return new StandardResult(ConstantDefinition.REQUEST_OK, null);
    }

    @ResponseBody
    @RequestMapping("/reject")
    public StandardResult reject(@RequestBody RiskSubmit riskSubmit){
        riskService.rejectApply(riskSubmit);
        return new StandardResult(ConstantDefinition.REQUEST_OK, null);
    }

    @ResponseBody
    @RequestMapping("/blockSearch")
    public StandardResult blockSearch(@RequestBody JSONObject request){
        int applyId = request.getInteger("id");
        RiskInfo riskInfo = riskService.getById(applyId);
        if (riskInfo == null || riskInfo.getStatus() == ConstantDefinition.RISK_SUBMIT_PENDING){
            return new StandardResult();
        }
        JSONObject result = new JSONObject();
        result.put("id", riskInfo.getId());
        result.put("check_id", riskInfo.getRiskCode());
        result.put("order_id", riskInfo.getOrderId());
        result.put("risk", riskInfo.getRiskType());
        result.put("applier_name", riskInfo.getSubmitter());
        result.put("apply_type", riskInfo.getApplyType());
        result.put("auditor_name", riskInfo.getAuditor());
        result.put("picker", riskInfo.getStatus());
        result.put("time", riskInfo.getAuditTime());
        result.put("block_id", riskInfo.getRiskBlock());
        result.put("block_height", BlockUtil.getBlockHeight(""));
        return new StandardResult(ConstantDefinition.REQUEST_OK, result);
    }

    @ResponseBody
    @RequestMapping("/compare")
    public StandardResult compare(@RequestBody JSONObject request){
        int applyId = request.getInteger("id");
        RiskInfo riskInfo = riskService.getById(applyId);
        if (riskInfo == null || riskInfo.getStatus() == ConstantDefinition.RISK_SUBMIT_PENDING){
            return new StandardResult();
        }
        JSONObject result = new JSONObject();
        result.put("id", riskInfo.getId());
        result.put("check_id", riskInfo.getRiskCode());
        result.put("order_id", riskInfo.getOrderId());
        result.put("risk", riskInfo.getRiskType());
        result.put("applier_id", riskInfo.getSubmitterId());
        result.put("applier_name", riskInfo.getSubmitter());
        result.put("apply_type", riskInfo.getApplyType());
        result.put("apply_reason", riskInfo.getSubmitComment());
        result.put("auditor_id", riskInfo.getAuditorId());
        result.put("auditor_name", riskInfo.getAuditor());
        result.put("picker", riskInfo.getStatus());
        result.put("picker_reason", riskInfo.getAuditComment());
        result.put("time", riskInfo.getAuditTime());
        result.put("block_id", riskInfo.getRiskBlock());
        result.put("block_height", BlockUtil.getBlockHeight(""));

        riskInfo = riskService.getFromBlockById(applyId);
        JSONObject blockResult = new JSONObject();
        blockResult.put("id", riskInfo.getId());
        blockResult.put("check_id", riskInfo.getRiskCode());
        blockResult.put("order_id", riskInfo.getOrderId());
        blockResult.put("risk", riskInfo.getRiskType());
        blockResult.put("applier_id", riskInfo.getSubmitterId());
        blockResult.put("applier_name", riskInfo.getSubmitter());
        blockResult.put("apply_type", riskInfo.getApplyType());
        blockResult.put("apply_reason", riskInfo.getSubmitComment());
        blockResult.put("auditor_id", riskInfo.getAuditorId());
        blockResult.put("auditor_name", riskInfo.getAuditor());
        blockResult.put("picker", riskInfo.getStatus());
        blockResult.put("picker_reason", riskInfo.getAuditComment());
        blockResult.put("time", riskInfo.getAuditTime());
        blockResult.put("block_id", riskInfo.getRiskBlock());
        blockResult.put("block_height", result.getInteger("block_height"));

        JSONObject isSame = new JSONObject();
        isSame.put("isSame", 1);
//        System.out.println(result.toJSONString());
//        System.out.println(blockResult.toJSONString());
        if (!result.toJSONString().equalsIgnoreCase(blockResult.toJSONString())){
            isSame.put("isSame", 0);
        }
        result.put("from_block", 0);
        blockResult.put("from_block", 1);
//        if (!result.getInteger("risk").equals(blockResult.getInteger("risk"))){
//            isSame.put("isSame", 0);
//        }
        JSONArray jsonArray = new JSONArray();
        jsonArray.add(result);
        jsonArray.add(blockResult);
        jsonArray.add(isSame);
        return new StandardResult(ConstantDefinition.REQUEST_OK, jsonArray);
    }
}
