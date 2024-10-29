package xyz.shiqihao.eshop.repo.model;

import jakarta.annotation.Generated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderSummaryDO {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.601984+08:00", comments="Source field: order_summary.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602174+08:00", comments="Source field: order_summary.creator")
    private Long creator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602301+08:00", comments="Source field: order_summary.updater")
    private Long updater;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602432+08:00", comments="Source field: order_summary.create_time")
    private LocalDateTime createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602562+08:00", comments="Source field: order_summary.update_time")
    private LocalDateTime updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602693+08:00", comments="Source field: order_summary.deleted")
    private Boolean deleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602822+08:00", comments="Source field: order_summary.amount")
    private BigDecimal amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602086+08:00", comments="Source field: order_summary.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602134+08:00", comments="Source field: order_summary.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602218+08:00", comments="Source field: order_summary.creator")
    public Long getCreator() {
        return creator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602262+08:00", comments="Source field: order_summary.creator")
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602348+08:00", comments="Source field: order_summary.updater")
    public Long getUpdater() {
        return updater;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602392+08:00", comments="Source field: order_summary.updater")
    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602477+08:00", comments="Source field: order_summary.create_time")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602523+08:00", comments="Source field: order_summary.create_time")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602606+08:00", comments="Source field: order_summary.update_time")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.60265+08:00", comments="Source field: order_summary.update_time")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602737+08:00", comments="Source field: order_summary.deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602782+08:00", comments="Source field: order_summary.deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602871+08:00", comments="Source field: order_summary.amount")
    public BigDecimal getAmount() {
        return amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.602915+08:00", comments="Source field: order_summary.amount")
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}