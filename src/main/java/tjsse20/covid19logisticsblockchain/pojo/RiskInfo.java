package tjsse20.covid19logisticsblockchain.pojo;

import tjsse20.covid19logisticsblockchain.util.DateUtil;

import java.util.Date;

public class RiskInfo {
    private Integer id;
    private String riskCode;
    private Integer riskType;
    private Integer submitterId;
    private String submitter;
    private Integer stationId;
    private String stationName;
    private String stationAddress;
    private Date submitTime;
    private String submitComment;
    private Integer auditorId;
    private String auditor;
    private String auditComment;
    private Integer status;
    private Integer applyType;
    private Integer orderId;

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getApplyType() {
        return applyType;
    }

    public void setApplyType(Integer applyType) {
        this.applyType = applyType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRiskCode() {
        return riskCode;
    }

    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    public Integer getRiskType() {
        return riskType;
    }

    public void setRiskType(Integer riskType) {
        this.riskType = riskType;
    }

    public Integer getSubmitterId() {
        return submitterId;
    }

    public void setSubmitterId(Integer submitterId) {
        this.submitterId = submitterId;
    }

    public String getSubmitter() {
        return submitter;
    }

    public void setSubmitter(String submitter) {
        this.submitter = submitter;
    }

    public Integer getStationId() {
        return stationId;
    }

    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getStationAddress() {
        return stationAddress;
    }

    public void setStationAddress(String stationAddress) {
        this.stationAddress = stationAddress;
    }

    public String getSubmitTime() {
        return submitTime == null ? null : DateUtil.dateToString(submitTime);
    }

    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    public String getSubmitComment() {
        return submitComment;
    }

    public void setSubmitComment(String submitComment) {
        this.submitComment = submitComment;
    }

    public Integer getAuditorId() {
        return auditorId;
    }

    public void setAuditorId(Integer auditorId) {
        this.auditorId = auditorId;
    }

    public String getAuditor() {
        return auditor;
    }

    public void setAuditor(String auditor) {
        this.auditor = auditor;
    }

    public String getAuditComment() {
        return auditComment;
    }

    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
