package tjsse20.covid19logisticsblockchain.pojo;

import tjsse20.covid19logisticsblockchain.util.DateUtil;

import java.util.Date;

public class OrderInfo {
    private int id;
    private Date orderTime;
    private String addressor;
    private String recipient;
    private int riskLevel;
    private String riskBlock;
    private String worker;

    public String getWorker() {
        return worker;
    }

    public void setWorker(String worker) {
        this.worker = worker;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderTime() {
        return orderTime == null ? null : DateUtil.dateToString(orderTime);
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
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

    public int getRiskLevel() {
        return riskLevel;
    }

    public void setRiskLevel(int riskLevel) {
        this.riskLevel = riskLevel;
    }

    public String getRiskBlock() {
        return riskBlock;
    }

    public void setRiskBlock(String riskBlock) {
        this.riskBlock = riskBlock;
    }
}
