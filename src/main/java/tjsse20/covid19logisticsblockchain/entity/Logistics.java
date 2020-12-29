package tjsse20.covid19logisticsblockchain.entity;

import java.util.Date;
import javax.annotation.Generated;

public class Logistics {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.station_id")
    private Integer stationId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.arriving_time")
    private Date arrivingTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.leaving_time")
    private Date leavingTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.risk_level")
    private Integer riskLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.submiter")
    private Integer submiter;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.status_")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.order_id")
    private Integer orderId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.station_id")
    public Integer getStationId() {
        return stationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.station_id")
    public void setStationId(Integer stationId) {
        this.stationId = stationId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.arriving_time")
    public Date getArrivingTime() {
        return arrivingTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.arriving_time")
    public void setArrivingTime(Date arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.956+08:00", comments="Source field: logistics.leaving_time")
    public Date getLeavingTime() {
        return leavingTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.leaving_time")
    public void setLeavingTime(Date leavingTime) {
        this.leavingTime = leavingTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.risk_level")
    public Integer getRiskLevel() {
        return riskLevel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.risk_level")
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.submiter")
    public Integer getSubmiter() {
        return submiter;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.submiter")
    public void setSubmiter(Integer submiter) {
        this.submiter = submiter;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.status_")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.status_")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.order_id")
    public Integer getOrderId() {
        return orderId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.957+08:00", comments="Source field: logistics.order_id")
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }
}