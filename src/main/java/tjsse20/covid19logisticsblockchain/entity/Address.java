package tjsse20.covid19logisticsblockchain.entity;

import javax.annotation.Generated;

public class Address {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.province")
    private String province;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.city")
    private String city;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.county")
    private String county;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.detailed_address")
    private String detailedAddress;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.969+08:00", comments="Source field: address.postcode")
    private String postcode;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.province")
    public String getProvince() {
        return province;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.province")
    public void setProvince(String province) {
        this.province = province;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.city")
    public String getCity() {
        return city;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.city")
    public void setCity(String city) {
        this.city = city;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.county")
    public String getCounty() {
        return county;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.968+08:00", comments="Source field: address.county")
    public void setCounty(String county) {
        this.county = county;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.969+08:00", comments="Source field: address.detailed_address")
    public String getDetailedAddress() {
        return detailedAddress;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.969+08:00", comments="Source field: address.detailed_address")
    public void setDetailedAddress(String detailedAddress) {
        this.detailedAddress = detailedAddress;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.969+08:00", comments="Source field: address.postcode")
    public String getPostcode() {
        return postcode;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-27T17:46:44.969+08:00", comments="Source field: address.postcode")
    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }
}