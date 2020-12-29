package tjsse20.covid19logisticsblockchain.entity;

import java.util.Date;
import javax.annotation.Generated;

public class RiskSubmit {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.risk_code")
    private String riskCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submitter")
    private Integer submitter;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.logistics_id")
    private Integer logisticsId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submit_comment")
    private String submitComment;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.type")
    private Integer type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.status_")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.auditor")
    private Integer auditor;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submit_time")
    private Date submitTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.attached_files")
    private String attachedFiles;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: risk_submit.audit_comment")
    private String auditComment;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: risk_submit.station_id")
    private Integer stationId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.risk_code")
    public String getRiskCode() {
        return riskCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.risk_code")
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submitter")
    public Integer getSubmitter() {
        return submitter;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submitter")
    public void setSubmitter(Integer submitter) {
        this.submitter = submitter;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.logistics_id")
    public Integer getLogisticsId() {
        return logisticsId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.logistics_id")
    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submit_comment")
    public String getSubmitComment() {
        return submitComment;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submit_comment")
    public void setSubmitComment(String submitComment) {
        this.submitComment = submitComment;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.type")
    public Integer getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.type")
    public void setType(Integer type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.status_")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.status_")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.auditor")
    public Integer getAuditor() {
        return auditor;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.auditor")
    public void setAuditor(Integer auditor) {
        this.auditor = auditor;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submit_time")
    public Date getSubmitTime() {
        return submitTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.967+08:00", comments="Source field: risk_submit.submit_time")
    public void setSubmitTime(Date submitTime) {
        this.submitTime = submitTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: risk_submit.attached_files")
    public String getAttachedFiles() {
        return attachedFiles;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: risk_submit.attached_files")
    public void setAttachedFiles(String attachedFiles) {
        this.attachedFiles = attachedFiles;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: risk_submit.audit_comment")
    public String getAuditComment() {
        return auditComment;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: risk_submit.audit_comment")
    public void setAuditComment(String auditComment) {
        this.auditComment = auditComment;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: risk_submit.station_id")
    public Integer getStationId() {
        return stationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: risk_submit.station_id")
    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }
}