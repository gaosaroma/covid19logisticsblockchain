package tjsse20.covid19logisticsblockchain.entity;

import javax.annotation.Generated;

public class RelatedPerson {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.953+08:00", comments="Source field: related_person.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.type")
    private Integer type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.address")
    private String address;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.contact_tel")
    private String contactTel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.contact_person")
    private String contactPerson;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.longitude")
    private Float longitude;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.latitude")
    private Float latitude;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.risk_level")
    private Integer riskLevel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.953+08:00", comments="Source field: related_person.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.type")
    public Integer getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.type")
    public void setType(Integer type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.address")
    public String getAddress() {
        return address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.954+08:00", comments="Source field: related_person.address")
    public void setAddress(String address) {
        this.address = address;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.contact_tel")
    public String getContactTel() {
        return contactTel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.contact_tel")
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.contact_person")
    public String getContactPerson() {
        return contactPerson;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.contact_person")
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.longitude")
    public Float getLongitude() {
        return longitude;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.longitude")
    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.latitude")
    public Float getLatitude() {
        return latitude;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.latitude")
    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.risk_level")
    public Integer getRiskLevel() {
        return riskLevel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.955+08:00", comments="Source field: related_person.risk_level")
    public void setRiskLevel(Integer riskLevel) {
        this.riskLevel = riskLevel;
    }
}