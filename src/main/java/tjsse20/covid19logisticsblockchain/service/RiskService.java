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
import tjsse20.covid19logisticsblockchain.mapper.RiskBlockMapper;
import tjsse20.covid19logisticsblockchain.mapper.RiskMapper;
import tjsse20.covid19logisticsblockchain.mapper.StationMapper;
import tjsse20.covid19logisticsblockchain.pojo.RiskInfo;
import tjsse20.covid19logisticsblockchain.resultparams.StandardResult;
import tjsse20.covid19logisticsblockchain.util.BlockUtil;
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

    @Autowired
    RiskBlockMapper riskBlockMapper;

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
        riskBlockMapper.insert(riskSubmit);
        riskMapper.insert(riskSubmit);
    }

    public void agreeApply(RiskSubmit riskSubmit){
        riskSubmit.setStatus(ConstantDefinition.RISK_SUBMIT_AUDITED);
        riskSubmit.setAuditTime(new Date());
        riskSubmit.setRiskBlock(String.valueOf(BlockUtil.getBlockId()));
        riskMapper.updateStatus(riskSubmit);
        riskBlockMapper.updateStatus(riskSubmit);
        RiskInfo riskInfo = riskMapper.select(riskSubmit.getId());
        if (riskInfo.getApplyType() == 2){
            stationMapper.updateRisk(riskInfo.getStationId(), ConstantDefinition.RISK_TYPE_NO);
            logisticsMapper.updateRisk(riskInfo.getStationId(), ConstantDefinition.RISK_TYPE_NO);
        }
        else {
            stationMapper.updateRisk(riskInfo.getStationId(), riskInfo.getRiskType());
            logisticsMapper.updateRisk(riskInfo.getStationId(), riskInfo.getRiskType());
        }
    }

    public RiskInfo getById(int id){
        return riskMapper.select(id);
    }

    public RiskInfo getFromBlockById(int id){
        return riskBlockMapper.select(id);
    }

    public void rejectApply(RiskSubmit riskSubmit){
        riskSubmit.setStatus(ConstantDefinition.RISK_SUBMIT_REJECTED);
        riskSubmit.setAuditTime(new Date());
        riskSubmit.setRiskBlock(String.valueOf(BlockUtil.getBlockId()));
        riskMapper.updateStatus(riskSubmit);
    }

    public List<RiskSubmit> getAll(){
        return riskMapper.selectAll();
    }

}
