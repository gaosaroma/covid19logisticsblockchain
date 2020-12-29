package tjsse20.covid19logisticsblockchain.service;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.mysql.cj.exceptions.CJOperationNotSupportedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tjsse20.covid19logisticsblockchain.entity.Risk;
import tjsse20.covid19logisticsblockchain.entity.RiskSubmit;
import tjsse20.covid19logisticsblockchain.entity.User;
import tjsse20.covid19logisticsblockchain.mapper.LogisticsMapper;
import tjsse20.covid19logisticsblockchain.mapper.RiskMapper;
import tjsse20.covid19logisticsblockchain.mapper.StationMapper;
import tjsse20.covid19logisticsblockchain.pojo.RiskInfo;
import tjsse20.covid19logisticsblockchain.util.ConstantDefinition;
import tjsse20.covid19logisticsblockchain.util.MD5Util;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RiskService {

    @Autowired
    RiskMapper riskMapper;

    @Autowired
    StationMapper stationMapper;

    @Autowired
    LogisticsMapper logisticsMapper;

    public List<RiskInfo> getAppliesByStatus(int status){
        return riskMapper.selectRiskByStatus(status);
    }

    public List<RiskInfo> getAppliesBySubmitter(int submitterId){
        return riskMapper.selectRiskBySubmitter(submitterId);
    }

    public List<RiskInfo> getAllApplies(){
        return riskMapper.selectAllRisks();
    }

    public void submitApply(RiskSubmit riskSubmit) {
        riskSubmit.setRiskCode(MD5Util.createId());
        riskSubmit.setStatus(0);
        riskSubmit.setAuditor(ConstantDefinition.DEFAULT_AUDITOR);
        riskSubmit.setSubmitTime(new Date());
        riskMapper.insert(riskSubmit);
    }

    public void agreeApply(RiskSubmit riskSubmit){
        riskSubmit.setStatus(ConstantDefinition.RISK_SUBMIT_AUDITED);
        riskMapper.updateStatus(riskSubmit);
        RiskInfo riskInfo = riskMapper.select(riskSubmit.getId());
        stationMapper.updateRisk(riskInfo.getStationId(), riskInfo.getRiskType());
        logisticsMapper.updateRisk(riskInfo.getStationId(), riskInfo.getRiskType());
    }

    public void rejectApply(RiskSubmit riskSubmit){
        riskSubmit.setStatus(ConstantDefinition.RISK_SUBMIT_REJECTED);
        riskMapper.updateStatus(riskSubmit);
    }

}
