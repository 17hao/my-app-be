package xyz.shiqihao.investment.repo.model;

import jakarta.annotation.Generated;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class InvestmentOperationDO {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.286459+08:00", comments="Source field: investment_operation.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.287902+08:00", comments="Source field: investment_operation.is_deleted")
    private Boolean isDeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288078+08:00", comments="Source field: investment_operation.create_time")
    private LocalDateTime createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288243+08:00", comments="Source field: investment_operation.update_time")
    private LocalDateTime updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288396+08:00", comments="Source field: investment_operation.op_date")
    private LocalDate opDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288572+08:00", comments="Source field: investment_operation.op_platform")
    private String opPlatform;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288748+08:00", comments="Source field: investment_operation.op_type")
    private String opType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288917+08:00", comments="Source field: investment_operation.op_item")
    private String opItem;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.289077+08:00", comments="Source field: investment_operation.op_amount")
    private String opAmount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.287591+08:00", comments="Source field: investment_operation.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.28784+08:00", comments="Source field: investment_operation.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.287957+08:00", comments="Source field: investment_operation.is_deleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288013+08:00", comments="Source field: investment_operation.is_deleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.28814+08:00", comments="Source field: investment_operation.create_time")
    public LocalDateTime getCreateTime() {
        return createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288195+08:00", comments="Source field: investment_operation.create_time")
    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288296+08:00", comments="Source field: investment_operation.update_time")
    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288348+08:00", comments="Source field: investment_operation.update_time")
    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288453+08:00", comments="Source field: investment_operation.op_date")
    public LocalDate getOpDate() {
        return opDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288517+08:00", comments="Source field: investment_operation.op_date")
    public void setOpDate(LocalDate opDate) {
        this.opDate = opDate;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288625+08:00", comments="Source field: investment_operation.op_platform")
    public String getOpPlatform() {
        return opPlatform;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288699+08:00", comments="Source field: investment_operation.op_platform")
    public void setOpPlatform(String opPlatform) {
        this.opPlatform = opPlatform == null ? null : opPlatform.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288807+08:00", comments="Source field: investment_operation.op_type")
    public String getOpType() {
        return opType;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288866+08:00", comments="Source field: investment_operation.op_type")
    public void setOpType(String opType) {
        this.opType = opType == null ? null : opType.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.288973+08:00", comments="Source field: investment_operation.op_item")
    public String getOpItem() {
        return opItem;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.289026+08:00", comments="Source field: investment_operation.op_item")
    public void setOpItem(String opItem) {
        this.opItem = opItem == null ? null : opItem.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.289132+08:00", comments="Source field: investment_operation.op_amount")
    public String getOpAmount() {
        return opAmount;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.289188+08:00", comments="Source field: investment_operation.op_amount")
    public void setOpAmount(String opAmount) {
        this.opAmount = opAmount == null ? null : opAmount.trim();
    }
}