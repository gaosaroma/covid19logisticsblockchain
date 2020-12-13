package tjsse20.covid19logisticsblockchain.entity;

import javax.annotation.Generated;

public class OrderCommodity {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.07+08:00", comments="Source field: order_commodity.order_id")
    private Integer orderId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.074+08:00", comments="Source field: order_commodity.commodity_id")
    private Integer commodityId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.074+08:00", comments="Source field: order_commodity.order_id")
    public Integer getOrderId() {
        return orderId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.074+08:00", comments="Source field: order_commodity.order_id")
    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.074+08:00", comments="Source field: order_commodity.commodity_id")
    public Integer getCommodityId() {
        return commodityId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2020-12-13T22:31:30.074+08:00", comments="Source field: order_commodity.commodity_id")
    public void setCommodityId(Integer commodityId) {
        this.commodityId = commodityId;
    }
}