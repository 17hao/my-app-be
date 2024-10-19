package xyz.shiqihao.app.infra.dal;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static xyz.shiqihao.app.infra.dal.OrderDODynamicSqlSupport.*;

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
import org.mybatis.dynamic.sql.delete.DeleteDSLCompleter;
import org.mybatis.dynamic.sql.select.CountDSLCompleter;
import org.mybatis.dynamic.sql.select.SelectDSLCompleter;
import org.mybatis.dynamic.sql.select.render.SelectStatementProvider;
import org.mybatis.dynamic.sql.update.UpdateDSL;
import org.mybatis.dynamic.sql.update.UpdateDSLCompleter;
import org.mybatis.dynamic.sql.update.UpdateModel;
import org.mybatis.dynamic.sql.util.SqlProviderAdapter;
import org.mybatis.dynamic.sql.util.mybatis3.CommonCountMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonDeleteMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonInsertMapper;
import org.mybatis.dynamic.sql.util.mybatis3.CommonUpdateMapper;
import org.mybatis.dynamic.sql.util.mybatis3.MyBatis3Utils;

@Mapper
public interface OrderMapper extends CommonCountMapper, CommonDeleteMapper, CommonInsertMapper<OrderDO>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.864561+08:00", comments="Source Table: orders")
    BasicColumn[] selectList = BasicColumn.columnList(id, creator, updater, createtime, updatetime, deleted, amount);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.859993+08:00", comments="Source Table: orders")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="OrderDOResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="creator", property="creator", jdbcType=JdbcType.BIGINT),
        @Result(column="updater", property="updater", jdbcType=JdbcType.BIGINT),
        @Result(column="createTime", property="createtime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="updateTime", property="updatetime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="deleted", property="deleted", jdbcType=JdbcType.BIT),
        @Result(column="amount", property="amount", jdbcType=JdbcType.DECIMAL)
    })
    List<OrderDO> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.860931+08:00", comments="Source Table: orders")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("OrderDOResult")
    Optional<OrderDO> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.861186+08:00", comments="Source Table: orders")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, orderDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.861429+08:00", comments="Source Table: orders")
    default int delete(DeleteDSLCompleter completer) {
        return MyBatis3Utils.deleteFrom(this::delete, orderDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.861799+08:00", comments="Source Table: orders")
    default int deleteByPrimaryKey(Long id_) {
        return delete(c -> 
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.862058+08:00", comments="Source Table: orders")
    default int insert(OrderDO row) {
        return MyBatis3Utils.insert(this::insert, row, orderDO, c ->
            c.map(id).toProperty("id")
            .map(creator).toProperty("creator")
            .map(updater).toProperty("updater")
            .map(createtime).toProperty("createtime")
            .map(updatetime).toProperty("updatetime")
            .map(deleted).toProperty("deleted")
            .map(amount).toProperty("amount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.86333+08:00", comments="Source Table: orders")
    default int insertMultiple(Collection<OrderDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, orderDO, c ->
            c.map(id).toProperty("id")
            .map(creator).toProperty("creator")
            .map(updater).toProperty("updater")
            .map(createtime).toProperty("createtime")
            .map(updatetime).toProperty("updatetime")
            .map(deleted).toProperty("deleted")
            .map(amount).toProperty("amount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.863841+08:00", comments="Source Table: orders")
    default int insertSelective(OrderDO row) {
        return MyBatis3Utils.insert(this::insert, row, orderDO, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(creator).toPropertyWhenPresent("creator", row::getCreator)
            .map(updater).toPropertyWhenPresent("updater", row::getUpdater)
            .map(createtime).toPropertyWhenPresent("createtime", row::getCreatetime)
            .map(updatetime).toPropertyWhenPresent("updatetime", row::getUpdatetime)
            .map(deleted).toPropertyWhenPresent("deleted", row::getDeleted)
            .map(amount).toPropertyWhenPresent("amount", row::getAmount)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.864987+08:00", comments="Source Table: orders")
    default Optional<OrderDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, orderDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.86521+08:00", comments="Source Table: orders")
    default List<OrderDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, orderDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.86544+08:00", comments="Source Table: orders")
    default List<OrderDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, orderDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.865721+08:00", comments="Source Table: orders")
    default Optional<OrderDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.86594+08:00", comments="Source Table: orders")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, orderDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.866188+08:00", comments="Source Table: orders")
    static UpdateDSL<UpdateModel> updateAllColumns(OrderDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(creator).equalTo(row::getCreator)
                .set(updater).equalTo(row::getUpdater)
                .set(createtime).equalTo(row::getCreatetime)
                .set(updatetime).equalTo(row::getUpdatetime)
                .set(deleted).equalTo(row::getDeleted)
                .set(amount).equalTo(row::getAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.866528+08:00", comments="Source Table: orders")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(OrderDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(creator).equalToWhenPresent(row::getCreator)
                .set(updater).equalToWhenPresent(row::getUpdater)
                .set(createtime).equalToWhenPresent(row::getCreatetime)
                .set(updatetime).equalToWhenPresent(row::getUpdatetime)
                .set(deleted).equalToWhenPresent(row::getDeleted)
                .set(amount).equalToWhenPresent(row::getAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.866971+08:00", comments="Source Table: orders")
    default int updateByPrimaryKey(OrderDO row) {
        return update(c ->
            c.set(creator).equalTo(row::getCreator)
            .set(updater).equalTo(row::getUpdater)
            .set(createtime).equalTo(row::getCreatetime)
            .set(updatetime).equalTo(row::getUpdatetime)
            .set(deleted).equalTo(row::getDeleted)
            .set(amount).equalTo(row::getAmount)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-11T22:16:46.867277+08:00", comments="Source Table: orders")
    default int updateByPrimaryKeySelective(OrderDO row) {
        return update(c ->
            c.set(creator).equalToWhenPresent(row::getCreator)
            .set(updater).equalToWhenPresent(row::getUpdater)
            .set(createtime).equalToWhenPresent(row::getCreatetime)
            .set(updatetime).equalToWhenPresent(row::getUpdatetime)
            .set(deleted).equalToWhenPresent(row::getDeleted)
            .set(amount).equalToWhenPresent(row::getAmount)
            .where(id, isEqualTo(row::getId))
        );
    }
}