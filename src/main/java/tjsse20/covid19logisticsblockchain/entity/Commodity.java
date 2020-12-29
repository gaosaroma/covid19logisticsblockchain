package tjsse20.covid19logisticsblockchain.entity;

import javax.annotation.Generated;

public class Commodity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: commodity.id")
    private Integer id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: commodity.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: commodity.price")
    private Double price;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.831+08:00", comments="Source field: commodity.comment")
    private String comment;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: commodity.id")
    public Integer getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: commodity.id")
    public void setId(Integer id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: commodity.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.83+08:00", comments="Source field: commodity.name")
    public void setName(String name) {
        this.name = name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.831+08:00", comments="Source field: commodity.price")
    public Double getPrice() {
        return price;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.831+08:00", comments="Source field: commodity.price")
    public void setPrice(Double price) {
        this.price = price;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.831+08:00", comments="Source field: commodity.comment")
    public String getComment() {
        return comment;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-29T23:02:48.831+08:00", comments="Source field: commodity.comment")
    public void setComment(String comment) {
        this.comment = comment;
    }
}