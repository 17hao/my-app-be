package xyz.shiqihao.infra.dal;

import jakarta.annotation.Generated;
import java.math.BigDecimal;
import java.sql.JDBCType;
import java.time.LocalDateTime;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class OrderDODynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.858324+08:00", comments="Source Table: orders")
    public static final OrderDO orderDO = new OrderDO();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.85868+08:00", comments="Source field: orders.id")
    public static final SqlColumn<Long> id = orderDO.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.859006+08:00", comments="Source field: orders.creator")
    public static final SqlColumn<Long> creator = orderDO.creator;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.859114+08:00", comments="Source field: orders.updater")
    public static final SqlColumn<Long> updater = orderDO.updater;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.859213+08:00", comments="Source field: orders.createTime")
    public static final SqlColumn<LocalDateTime> createtime = orderDO.createtime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.859302+08:00", comments="Source field: orders.updateTime")
    public static final SqlColumn<LocalDateTime> updatetime = orderDO.updatetime;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.859393+08:00", comments="Source field: orders.deleted")
    public static final SqlColumn<Boolean> deleted = orderDO.deleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.859491+08:00", comments="Source field: orders.amount")
    public static final SqlColumn<BigDecimal> amount = orderDO.amount;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.85853+08:00", comments="Source Table: orders")
    public static final class OrderDO extends AliasableSqlTable<OrderDO> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> creator = column("creator", JDBCType.BIGINT);

        public final SqlColumn<Long> updater = column("updater", JDBCType.BIGINT);

        public final SqlColumn<LocalDateTime> createtime = column("createTime", JDBCType.TIMESTAMP);

        public final SqlColumn<LocalDateTime> updatetime = column("updateTime", JDBCType.TIMESTAMP);

        public final SqlColumn<Boolean> deleted = column("deleted", JDBCType.BIT);

        public final SqlColumn<BigDecimal> amount = column("amount", JDBCType.DECIMAL);

        public OrderDO() {
            super("orders", OrderDO::new);
        }
    }
}