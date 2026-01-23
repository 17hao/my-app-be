package xyz.shiqihao.investment.repository.dao;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import java.time.LocalDate;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class InvestmentOperationDODynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.291014+08:00", comments="Source Table: investment_operation")
    public static final InvestmentOperationDO investmentOperationDO = new InvestmentOperationDO();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.291314+08:00", comments="Source field: investment_operation.id")
    public static final SqlColumn<Long> id = investmentOperationDO.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.291621+08:00", comments="Source field: investment_operation.is_deleted")
    public static final SqlColumn<Boolean> isDeleted = investmentOperationDO.isDeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.291736+08:00", comments="Source field: investment_operation.create_time")
    public static final SqlColumn<LocalDateTime> createTime = investmentOperationDO.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.291867+08:00", comments="Source field: investment_operation.update_time")
    public static final SqlColumn<LocalDateTime> updateTime = investmentOperationDO.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.291966+08:00", comments="Source field: investment_operation.op_date")
    public static final SqlColumn<LocalDate> opDate = investmentOperationDO.opDate;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.292085+08:00", comments="Source field: investment_operation.op_platform")
    public static final SqlColumn<String> opPlatform = investmentOperationDO.opPlatform;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.292177+08:00", comments="Source field: investment_operation.op_type")
    public static final SqlColumn<String> opType = investmentOperationDO.opType;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.292265+08:00", comments="Source field: investment_operation.op_item")
    public static final SqlColumn<String> opItem = investmentOperationDO.opItem;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.292386+08:00", comments="Source field: investment_operation.op_amount")
    public static final SqlColumn<String> opAmount = investmentOperationDO.opAmount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.29119+08:00", comments="Source Table: investment_operation")
    public static final class InvestmentOperationDO extends AliasableSqlTable<InvestmentOperationDO> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Boolean> isDeleted = column("is_deleted", JDBCType.BIT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDate> opDate = column("op_date", JDBCType.DATE);

        public final SqlColumn<String> opPlatform = column("op_platform", JDBCType.VARCHAR);

        public final SqlColumn<String> opType = column("op_type", JDBCType.VARCHAR);

        public final SqlColumn<String> opItem = column("op_item", JDBCType.VARCHAR);

        public final SqlColumn<String> opAmount = column("op_amount", JDBCType.VARCHAR);

        public InvestmentOperationDO() {
            super("investment_operation", InvestmentOperationDO::new);
        }
    }
}