package tjsse20.covid19logisticsblockchain.pojo;

import tjsse20.covid19logisticsblockchain.util.DateUtil;

import java.util.Date;

public class TimelineInfo {
    private Integer status;
    private Date arrivingTime;
    private Date leavingTime;
    private String stationName;
    private String workerName;
    private Integer risk;
    private Float longitude;
    private Float latitude;
    private String riskBlock;
    private String stationType;

    public String getStationType() {
        return stationType;
    }

    public void setStationType(String stationType) {
        this.stationType = stationType;
    }

    public String getRiskBlock() {
        return riskBlock;
    }

    public void setRiskBlock(String riskBlock) {
        this.riskBlock = riskBlock;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getArrivingTime() {
        return arrivingTime == null ? null : DateUtil.dateToString(arrivingTime);
    }

    public void setArrivingTime(Date arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public String getLeavingTime() {
        return leavingTime == null ? null : DateUtil.dateToString(leavingTime);
    }

    public void setLeavingTime(Date leavingTime) {
        this.leavingTime = leavingTime;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getWorkerName() {
        return workerName;
    }

    public void setWorkerName(String workerName) {
        this.workerName = workerName;
    }

    public Integer getRisk() {
        return risk;
    }

    public void setRisk(Integer risk) {
        this.risk = risk;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }
}
