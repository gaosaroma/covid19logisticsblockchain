package tjsse20.covid19logisticsblockchain.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tjsse20.covid19logisticsblockchain.entity.Logistics;
import tjsse20.covid19logisticsblockchain.entity.Order;
import tjsse20.covid19logisticsblockchain.entity.RiskSubmit;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.pojo.LogisticsInfo;
import tjsse20.covid19logisticsblockchain.pojo.RiskInfo;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.service.LogisticsService;
import tjsse20.covid19logisticsblockchain.service.RiskService;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;

import java.lang.reflect.Array;
import java.util.ArrayList;
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
        return new StandardResult(ConstantDefinition.REQUEST_OK, riskService.getById(riskInfo.getId()));
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
        riskService.submitApply(riskSubmit);
        return new StandardResult(ConstantDefinition.REQUEST_OK, null);
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

}
