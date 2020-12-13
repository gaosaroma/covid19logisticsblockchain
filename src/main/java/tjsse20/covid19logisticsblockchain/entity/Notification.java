package tjsse20.covid19logisticsblockchain.entity;

import javax.annotation.Generated;

public class Notification {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.08+08:00", comments="Source field: notification.uid")
    private Integer uid;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.08+08:00", comments="Source field: notification.description")
    private String description;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.08+08:00", comments="Source field: notification.uid")
    public Integer getUid() {
        return uid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.08+08:00", comments="Source field: notification.uid")
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.08+08:00", comments="Source field: notification.description")
    public String getDescription() {
        return description;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.081+08:00", comments="Source field: notification.description")
    public void setDescription(String description) {
        this.description = description;
    }
}