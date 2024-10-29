package xyz.shiqihao.eshop.repo.model;

import jakarta.annotation.Generated;
import java.math.BigDecimal;

public class OrderItemDO {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.530674+08:00", comments="Source field: order_item.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.531833+08:00", comments="Source field: order_item.order_summary_id")
    private Long orderSummaryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.531992+08:00", comments="Source field: order_item.quantity")
    private Integer quantity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.532148+08:00", comments="Source field: order_item.unit_price")
    private BigDecimal unitPrice;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.531558+08:00", comments="Source field: order_item.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.531771+08:00", comments="Source field: order_item.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.53189+08:00", comments="Source field: order_item.order_summary_id")
    public Long getOrderSummaryId() {
        return orderSummaryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.531944+08:00", comments="Source field: order_item.order_summary_id")
    public void setOrderSummaryId(Long orderSummaryId) {
        this.orderSummaryId = orderSummaryId;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.532045+08:00", comments="Source field: order_item.quantity")
    public Integer getQuantity() {
        return quantity;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.532099+08:00", comments="Source field: order_item.quantity")
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.53221+08:00", comments="Source field: order_item.unit_price")
    public BigDecimal getUnitPrice() {
        return unitPrice;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.532264+08:00", comments="Source field: order_item.unit_price")
    public void setUnitPrice(BigDecimal unitPrice) {
        this.unitPrice = unitPrice;
    }
}