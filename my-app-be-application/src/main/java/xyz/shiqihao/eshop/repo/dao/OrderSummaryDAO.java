package xyz.shiqihao.eshop.repo.dao;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static xyz.shiqihao.eshop.repo.dao.OrderSummaryDODynamicSqlSupport.*;

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
import xyz.shiqihao.eshop.repo.model.OrderSummaryDO;

@Mapper
public interface OrderSummaryDAO extends CommonCountMapper, CommonInsertMapper<OrderSummaryDO>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604534+08:00", comments="Source Table: order_summary")
    BasicColumn[] selectList = BasicColumn.columnList(id, creator, updater, createTime, updateTime, deleted, amount);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.60381+08:00", comments="Source Table: order_summary")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderSummaryDOResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="creator", property="creator", jdbcType=JdbcType.BIGINT),
        @Result(column="updater", property="updater", jdbcType=JdbcType.BIGINT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL)
    })
    List<OrderSummaryDO> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603919+08:00", comments="Source Table: order_summary")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderSummaryDOResult")
    Optional<OrderSummaryDO> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.603982+08:00", comments="Source Table: order_summary")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, orderSummaryDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604125+08:00", comments="Source Table: order_summary")
    default int insert(OrderSummaryDO row) {
        return MyBatis3Utils.insert(this::insert, row, orderSummaryDO, c ->
            c.map(id).toProperty("id")
            .map(creator).toProperty("creator")
            .map(updater).toProperty("updater")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(deleted).toProperty("deleted")
            .map(amount).toProperty("amount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604257+08:00", comments="Source Table: order_summary")
    default int insertMultiple(Collection<OrderSummaryDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, orderSummaryDO, c ->
            c.map(id).toProperty("id")
            .map(creator).toProperty("creator")
            .map(updater).toProperty("updater")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(deleted).toProperty("deleted")
            .map(amount).toProperty("amount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604366+08:00", comments="Source Table: order_summary")
    default int insertSelective(OrderSummaryDO row) {
        return MyBatis3Utils.insert(this::insert, row, orderSummaryDO, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(creator).toPropertyWhenPresent("creator", row::getCreator)
            .map(updater).toPropertyWhenPresent("updater", row::getUpdater)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(deleted).toPropertyWhenPresent("deleted", row::getDeleted)
            .map(amount).toPropertyWhenPresent("amount", row::getAmount)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604582+08:00", comments="Source Table: order_summary")
    default Optional<OrderSummaryDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, orderSummaryDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604632+08:00", comments="Source Table: order_summary")
    default List<OrderSummaryDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, orderSummaryDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604692+08:00", comments="Source Table: order_summary")
    default List<OrderSummaryDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, orderSummaryDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604742+08:00", comments="Source Table: order_summary")
    default Optional<OrderSummaryDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604796+08:00", comments="Source Table: order_summary")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, orderSummaryDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604848+08:00", comments="Source Table: order_summary")
    static UpdateDSL<UpdateModel> updateAllColumns(OrderSummaryDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(creator).equalTo(row::getCreator)
                .set(updater).equalTo(row::getUpdater)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(deleted).equalTo(row::getDeleted)
                .set(amount).equalTo(row::getAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.604948+08:00", comments="Source Table: order_summary")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrderSummaryDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(creator).equalToWhenPresent(row::getCreator)
                .set(updater).equalToWhenPresent(row::getUpdater)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(deleted).equalToWhenPresent(row::getDeleted)
                .set(amount).equalToWhenPresent(row::getAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.605062+08:00", comments="Source Table: order_summary")
    default int updateByPrimaryKey(OrderSummaryDO row) {
        return update(c ->
            c.set(creator).equalTo(row::getCreator)
            .set(updater).equalTo(row::getUpdater)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(deleted).equalTo(row::getDeleted)
            .set(amount).equalTo(row::getAmount)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-29T23:37:38.605173+08:00", comments="Source Table: order_summary")
    default int updateByPrimaryKeySelective(OrderSummaryDO row) {
        return update(c ->
            c.set(creator).equalToWhenPresent(row::getCreator)
            .set(updater).equalToWhenPresent(row::getUpdater)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(deleted).equalToWhenPresent(row::getDeleted)
            .set(amount).equalToWhenPresent(row::getAmount)
            .where(id, isEqualTo(row::getId))
        );
    }
}