package tjsse20.covid19logisticsblockchain.entity;

import javax.annotation.Generated;

public class Risk {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.risk_code")
    private String riskCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.submitter")
    private Integer submitter;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.logistics_id")
    private Integer logisticsId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.station_id")
    private Integer stationId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.risk_description")
    private String riskDescription;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.attaches")
    private String attaches;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.cur_status")
    private Integer curStatus;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.cur_addr")
    private String curAddr;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.risk_code")
    public String getRiskCode() {
        return riskCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.risk_code")
    public void setRiskCode(String riskCode) {
        this.riskCode = riskCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.submitter")
    public Integer getSubmitter() {
        return submitter;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.submitter")
    public void setSubmitter(Integer submitter) {
        this.submitter = submitter;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.logistics_id")
    public Integer getLogisticsId() {
        return logisticsId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.logistics_id")
    public void setLogisticsId(Integer logisticsId) {
        this.logisticsId = logisticsId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.837+08:00", comments="Source field: risk.station_id")
    public Integer getStationId() {
        return stationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.station_id")
    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.risk_description")
    public String getRiskDescription() {
        return riskDescription;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.risk_description")
    public void setRiskDescription(String riskDescription) {
        this.riskDescription = riskDescription;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.attaches")
    public String getAttaches() {
        return attaches;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.attaches")
    public void setAttaches(String attaches) {
        this.attaches = attaches;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.cur_status")
    public Integer getCurStatus() {
        return curStatus;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.cur_status")
    public void setCurStatus(Integer curStatus) {
        this.curStatus = curStatus;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.cur_addr")
    public String getCurAddr() {
        return curAddr;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.838+08:00", comments="Source field: risk.cur_addr")
    public void setCurAddr(String curAddr) {
        this.curAddr = curAddr;
    }
}