package xyz.shiqihao.app.infra.dal;

import jakarta.annotation.Generated;
import java.math.BigDecimal;
import java.time.LocalDateTime;

public class OrderDO {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.854135+08:00", comments="Source field: orders.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.855699+08:00", comments="Source field: orders.creator")
    private Long creator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.855882+08:00", comments="Source field: orders.updater")
    private Long updater;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.85604+08:00", comments="Source field: orders.createTime")
    private LocalDateTime createtime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856207+08:00", comments="Source field: orders.updateTime")
    private LocalDateTime updatetime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856367+08:00", comments="Source field: orders.deleted")
    private Boolean deleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856525+08:00", comments="Source field: orders.amount")
    private BigDecimal amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.8554+08:00", comments="Source field: orders.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.85563+08:00", comments="Source field: orders.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.855762+08:00", comments="Source field: orders.creator")
    public Long getCreator() {
        return creator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.855824+08:00", comments="Source field: orders.creator")
    public void setCreator(Long creator) {
        this.creator = creator;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.855939+08:00", comments="Source field: orders.updater")
    public Long getUpdater() {
        return updater;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.855993+08:00", comments="Source field: orders.updater")
    public void setUpdater(Long updater) {
        this.updater = updater;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856103+08:00", comments="Source field: orders.createTime")
    public LocalDateTime getCreatetime() {
        return createtime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856158+08:00", comments="Source field: orders.createTime")
    public void setCreatetime(LocalDateTime createtime) {
        this.createtime = createtime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856261+08:00", comments="Source field: orders.updateTime")
    public LocalDateTime getUpdatetime() {
        return updatetime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856314+08:00", comments="Source field: orders.updateTime")
    public void setUpdatetime(LocalDateTime updatetime) {
        this.updatetime = updatetime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856423+08:00", comments="Source field: orders.deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856477+08:00", comments="Source field: orders.deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856597+08:00", comments="Source field: orders.amount")
    public BigDecimal getAmount() {
        return amount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.856671+08:00", comments="Source field: orders.amount")
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}