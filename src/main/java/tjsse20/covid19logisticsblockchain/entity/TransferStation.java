package tjsse20.covid19logisticsblockchain.entity;

import javax.annotation.Generated;

public class TransferStation {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.086+08:00", comments="Source field: transfer_station.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.086+08:00", comments="Source field: transfer_station.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.087+08:00", comments="Source field: transfer_station.address_id")
    private Integer addressId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.088+08:00", comments="Source field: transfer_station.contact_tel")
    private String contactTel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.status_")
    private Integer status;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.risk")
    private Integer risk;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.transportation_type")
    private String transportationType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.09+08:00", comments="Source field: transfer_station.transportation_code")
    private String transportationCode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.09+08:00", comments="Source field: transfer_station.transportation_comment")
    private String transportationComment;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.086+08:00", comments="Source field: transfer_station.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.086+08:00", comments="Source field: transfer_station.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.086+08:00", comments="Source field: transfer_station.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.087+08:00", comments="Source field: transfer_station.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.088+08:00", comments="Source field: transfer_station.address_id")
    public Integer getAddressId() {
        return addressId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.088+08:00", comments="Source field: transfer_station.address_id")
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.088+08:00", comments="Source field: transfer_station.contact_tel")
    public String getContactTel() {
        return contactTel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.contact_tel")
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.status_")
    public Integer getStatus() {
        return status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.status_")
    public void setStatus(Integer status) {
        this.status = status;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.risk")
    public Integer getRisk() {
        return risk;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.risk")
    public void setRisk(Integer risk) {
        this.risk = risk;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.transportation_type")
    public String getTransportationType() {
        return transportationType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.089+08:00", comments="Source field: transfer_station.transportation_type")
    public void setTransportationType(String transportationType) {
        this.transportationType = transportationType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.09+08:00", comments="Source field: transfer_station.transportation_code")
    public String getTransportationCode() {
        return transportationCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.09+08:00", comments="Source field: transfer_station.transportation_code")
    public void setTransportationCode(String transportationCode) {
        this.transportationCode = transportationCode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.09+08:00", comments="Source field: transfer_station.transportation_comment")
    public String getTransportationComment() {
        return transportationComment;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.09+08:00", comments="Source field: transfer_station.transportation_comment")
    public void setTransportationComment(String transportationComment) {
        this.transportationComment = transportationComment;
    }
}