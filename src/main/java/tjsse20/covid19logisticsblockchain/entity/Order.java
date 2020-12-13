package tjsse20.covid19logisticsblockchain.entity;

import java.util.Date;
import javax.annotation.Generated;

public class Order {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.093+08:00", comments="Source field: order_.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.logistics_number")
    private String logisticsNumber;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.order_time")
    private Date orderTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.arriving_time")
    private Date arrivingTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.addressor_id")
    private Integer addressorId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.recipient_id")
    private Integer recipientId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.093+08:00", comments="Source field: order_.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.logistics_number")
    public String getLogisticsNumber() {
        return logisticsNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.logistics_number")
    public void setLogisticsNumber(String logisticsNumber) {
        this.logisticsNumber = logisticsNumber;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.order_time")
    public Date getOrderTime() {
        return orderTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.order_time")
    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.arriving_time")
    public Date getArrivingTime() {
        return arrivingTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.arriving_time")
    public void setArrivingTime(Date arrivingTime) {
        this.arrivingTime = arrivingTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.addressor_id")
    public Integer getAddressorId() {
        return addressorId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.094+08:00", comments="Source field: order_.addressor_id")
    public void setAddressorId(Integer addressorId) {
        this.addressorId = addressorId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.095+08:00", comments="Source field: order_.recipient_id")
    public Integer getRecipientId() {
        return recipientId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.095+08:00", comments="Source field: order_.recipient_id")
    public void setRecipientId(Integer recipientId) {
        this.recipientId = recipientId;
    }
}