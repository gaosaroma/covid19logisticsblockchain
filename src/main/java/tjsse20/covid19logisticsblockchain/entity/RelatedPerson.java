package tjsse20.covid19logisticsblockchain.entity;

import javax.annotation.Generated;

public class RelatedPerson {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.078+08:00", comments="Source field: related_person.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.078+08:00", comments="Source field: related_person.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.type")
    private Integer type;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.address_id")
    private Integer addressId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.contact_tel")
    private String contactTel;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.08+08:00", comments="Source field: related_person.contact_person")
    private String contactPerson;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.078+08:00", comments="Source field: related_person.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.078+08:00", comments="Source field: related_person.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.type")
    public Integer getType() {
        return type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.type")
    public void setType(Integer type) {
        this.type = type;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.address_id")
    public Integer getAddressId() {
        return addressId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.address_id")
    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.contact_tel")
    public String getContactTel() {
        return contactTel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.079+08:00", comments="Source field: related_person.contact_tel")
    public void setContactTel(String contactTel) {
        this.contactTel = contactTel;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.08+08:00", comments="Source field: related_person.contact_person")
    public String getContactPerson() {
        return contactPerson;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.08+08:00", comments="Source field: related_person.contact_person")
    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }
}