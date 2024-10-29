package xyz.shiqihao.eshop.repo.dao;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static xyz.shiqihao.eshop.repo.dao.OrderItemDODynamicSqlSupport.*;

import jakarta.annotation.Generated;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.ResultMap;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.dynamic.sql.BasicColumn;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;
import xyz.shiqihao.eshop.repo.model.OrderItemDO;

@Mapper
public interface OrderItemDAO extends CommonCountMapper, CommonInsertMapper<OrderItemDO>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.539583+08:00", comments="Source Table: order_item")
    BasicColumn[] selectList = BasicColumn.columnList(id, orderSummaryId, quantity, unitPrice);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.535039+08:00", comments="Source Table: order_item")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderItemDOResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="order_summary_id", property="orderSummaryId", jdbcType=JdbcType.BIGINT),
        @Result(column="quantity", property="quantity", jdbcType=JdbcType.INTEGER),
        @Result(column="unit_price", property="unitPrice", jdbcType=JdbcType.DECIMAL)
    })
    List<OrderItemDO> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.535967+08:00", comments="Source Table: order_item")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderItemDOResult")
    Optional<OrderItemDO> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.536227+08:00", comments="Source Table: order_item")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, orderItemDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.537033+08:00", comments="Source Table: order_item")
    default int insert(OrderItemDO row) {
        return MyBatis3Utils.insert(this::insert, row, orderItemDO, c ->
            c.map(id).toProperty("id")
            .map(orderSummaryId).toProperty("orderSummaryId")
            .map(quantity).toProperty("quantity")
            .map(unitPrice).toProperty("unitPrice")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.538247+08:00", comments="Source Table: order_item")
    default int insertMultiple(Collection<OrderItemDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, orderItemDO, c ->
            c.map(id).toProperty("id")
            .map(orderSummaryId).toProperty("orderSummaryId")
            .map(quantity).toProperty("quantity")
            .map(unitPrice).toProperty("unitPrice")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.538799+08:00", comments="Source Table: order_item")
    default int insertSelective(OrderItemDO row) {
        return MyBatis3Utils.insert(this::insert, row, orderItemDO, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(orderSummaryId).toPropertyWhenPresent("orderSummaryId", row::getOrderSummaryId)
            .map(quantity).toPropertyWhenPresent("quantity", row::getQuantity)
            .map(unitPrice).toPropertyWhenPresent("unitPrice", row::getUnitPrice)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.540035+08:00", comments="Source Table: order_item")
    default Optional<OrderItemDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, orderItemDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.540291+08:00", comments="Source Table: order_item")
    default List<OrderItemDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, orderItemDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.540544+08:00", comments="Source Table: order_item")
    default List<OrderItemDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, orderItemDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.540782+08:00", comments="Source Table: order_item")
    default Optional<OrderItemDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.540997+08:00", comments="Source Table: order_item")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, orderItemDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.541247+08:00", comments="Source Table: order_item")
    static UpdateDSL<UpdateModel> updateAllColumns(OrderItemDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(orderSummaryId).equalTo(row::getOrderSummaryId)
                .set(quantity).equalTo(row::getQuantity)
                .set(unitPrice).equalTo(row::getUnitPrice);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.541582+08:00", comments="Source Table: order_item")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrderItemDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(orderSummaryId).equalToWhenPresent(row::getOrderSummaryId)
                .set(quantity).equalToWhenPresent(row::getQuantity)
                .set(unitPrice).equalToWhenPresent(row::getUnitPrice);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.542019+08:00", comments="Source Table: order_item")
    default int updateByPrimaryKey(OrderItemDO row) {
        return update(c ->
            c.set(orderSummaryId).equalTo(row::getOrderSummaryId)
            .set(quantity).equalTo(row::getQuantity)
            .set(unitPrice).equalTo(row::getUnitPrice)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.542333+08:00", comments="Source Table: order_item")
    default int updateByPrimaryKeySelective(OrderItemDO row) {
        return update(c ->
            c.set(orderSummaryId).equalToWhenPresent(row::getOrderSummaryId)
            .set(quantity).equalToWhenPresent(row::getQuantity)
            .set(unitPrice).equalToWhenPresent(row::getUnitPrice)
            .where(id, isEqualTo(row::getId))
        );
    }
}