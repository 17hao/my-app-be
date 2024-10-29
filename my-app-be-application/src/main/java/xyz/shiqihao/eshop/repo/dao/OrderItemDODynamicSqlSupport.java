package xyz.shiqihao.eshop.repo.dao;

import jakarta.annotation.Generated;
import java.math.BigDecimal;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class OrderItemDODynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.533884+08:00", comments="Source Table: order_item")
    public static final OrderItemDO orderItemDO = new OrderItemDO();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.534186+08:00", comments="Source field: order_item.id")
    public static final SqlColumn<Long> id = orderItemDO.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.534463+08:00", comments="Source field: order_item.order_summary_id")
    public static final SqlColumn<Long> orderSummaryId = orderItemDO.orderSummaryId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.534559+08:00", comments="Source field: order_item.quantity")
    public static final SqlColumn<Integer> quantity = orderItemDO.quantity;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.534656+08:00", comments="Source field: order_item.unit_price")
    public static final SqlColumn<BigDecimal> unitPrice = orderItemDO.unitPrice;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.53406+08:00", comments="Source Table: order_item")
    public static final class OrderItemDO extends AliasableSqlTable<OrderItemDO> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<Long> orderSummaryId = column("order_summary_id", JDBCType.BIGINT);

        public final SqlColumn<Integer> quantity = column("quantity", JDBCType.INTEGER);

        public final SqlColumn<BigDecimal> unitPrice = column("unit_price", JDBCType.DECIMAL);

        public OrderItemDO() {
            super("order_item", OrderItemDO::new);
        }
    }
}