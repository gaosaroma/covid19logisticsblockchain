package tjsse20.covid19logisticsblockchain.entity;

import tjsse20.covid19logisticsblockchain.util.DateUtil;

import java.util.Date;
import javax.annotation.Generated;

public class Logistics {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.station_id")
    private Integer stationId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.arriving_time")
    private Date arrivingTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.leaving_time")
    private Date leavingTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.risk_level")
    private Integer riskLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.submiter")
    private Integer submiter;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.status_")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.order_id")
    private Integer orderId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: logistics.risk_block")
    private String riskBlock;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.station_id")
    public Integer getStationId() {
        return stationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.station_id")
    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.arriving_time")
    public String getArrivingTime() {
        return arrivingTime == null ? null : DateUtil.dateToString(arrivingTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.arriving_time")
    public void setArrivingTime(Date arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.leaving_time")
    public String getLeavingTime() {
        return leavingTime == null ? null : DateUtil.dateToString(leavingTime);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.828+08:00", comments="Source field: logistics.leaving_time")
    public void setLeavingTime(Date leavingTime) {
        this.leavingTime = leavingTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.risk_level")
    public Integer getRiskLevel() {
        return riskLevel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.risk_level")
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.submiter")
    public Integer getSubmiter() {
        return submiter;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.submiter")
    public void setSubmiter(Integer submiter) {
        this.submiter = submiter;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.status_")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.status_")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.order_id")
    public Integer getOrderId() {
        return orderId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.829+08:00", comments="Source field: logistics.order_id")
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: logistics.risk_block")
    public String getRiskBlock() {
        return riskBlock;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: logistics.risk_block")
    public void setRiskBlock(String riskBlock) {
        this.riskBlock = riskBlock;
    }
}