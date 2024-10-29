package xyz.shiqihao.eshop.repo.dao;

import jakarta.annotation.Generated;
import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class OrderSummaryDODynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603019+08:00", comments="Source Table: order_summary")
    public static final OrderSummaryDO orderSummaryDO = new OrderSummaryDO();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.60321+08:00", comments="Source field: order_summary.id")
    public static final SqlColumn<Long> id = orderSummaryDO.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603305+08:00", comments="Source field: order_summary.creator")
    public static final SqlColumn<Long> creator = orderSummaryDO.creator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603389+08:00", comments="Source field: order_summary.updater")
    public static final SqlColumn<Long> updater = orderSummaryDO.updater;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.60347+08:00", comments="Source field: order_summary.create_time")
    public static final SqlColumn<LocalDateTime> createTime = orderSummaryDO.createTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603562+08:00", comments="Source field: order_summary.update_time")
    public static final SqlColumn<LocalDateTime> updateTime = orderSummaryDO.updateTime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603657+08:00", comments="Source field: order_summary.deleted")
    public static final SqlColumn<Boolean> deleted = orderSummaryDO.deleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603736+08:00", comments="Source field: order_summary.amount")
    public static final SqlColumn<BigDecimal> amount = orderSummaryDO.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603119+08:00", comments="Source Table: order_summary")
    public static final class OrderSummaryDO extends AliasableSqlTable<OrderSummaryDO> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> creator = column("creator", JDBCType.BIGINT);

        public final SqlColumn<Long> updater = column("updater", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createTime = column("create_time", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updateTime = column("update_time", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> deleted = column("deleted", JDBCType.BIT);

        public final SqlColumn<BigDecimal> amount = column("amount", JDBCType.DECIMAL);

        public OrderSummaryDO() {
            super("order_summary", OrderSummaryDO::new);
        }
    }
}