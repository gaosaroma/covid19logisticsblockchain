package tjsse20.covid19logisticsblockchain.pojo;

import java.awt.geom.FlatteningPathIterator;
import java.util.Date;

public class LogisticsInfo {
    private Integer id;
    private String logisticsNumber;
    private Integer status;
    private Date arrivingTime;
    private Date leavingTime;
    private Integer riskLevel;
    private String stationName;
    private String currAddress;
    private String addressor;
    private String srcAddress;
    private Float srcLongitude;
    private Float srcLatitude;
    private String recipient;
    private String destAddress;
    private Float destLongitude;
    private Float destLatitude;

    public Float getSrcLongitude() {
        return srcLongitude;
    }

    public void setSrcLongitude(Float srcLongitude) {
        this.srcLongitude = srcLongitude;
    }

    public Float getSrcLatitude() {
        return srcLatitude;
    }

    public void setSrcLatitude(Float srcLatitude) {
        this.srcLatitude = srcLatitude;
    }

    public Float getDestLongitude() {
        return destLongitude;
    }

    public void setDestLongitude(Float destLongitude) {
        this.destLongitude = destLongitude;
    }

    public Float getDestLatitude() {
        return destLatitude;
    }

    public void setDestLatitude(Float destLatitude) {
        this.destLatitude = destLatitude;
    }

    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }

    public String getAddressor() {
        return addressor;
    }

    public void setAddressor(String addressor) {
        this.addressor = addressor;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getArrivingTime() {
        return arrivingTime;
    }

    public void setArrivingTime(Date arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    public Date getLeavingTime() {
        return leavingTime;
    }

    public void setLeavingTime(Date leavingTime) {
        this.leavingTime = leavingTime;
    }

    public Integer getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getStationName() {
        return stationName;
    }

    public void setStationName(String stationName) {
        this.stationName = stationName;
    }

    public String getCurrAddress() {
        return currAddress;
    }

    public void setCurrAddress(String currAddress) {
        this.currAddress = currAddress;
    }

    public String getSrcAddress() {
        return srcAddress;
    }

    public void setSrcAddress(String srcAddress) {
        this.srcAddress = srcAddress;
    }

    public String getDestAddress() {
        return destAddress;
    }

    public void setDestAddress(String destAddress) {
        this.destAddress = destAddress;
    }
}
