package xyz.shiqihao.investment.repo.dao;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static xyz.shiqihao.investment.repo.dao.InvestmentOperationDODynamicSqlSupport.*;

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
import xyz.shiqihao.investment.repo.model.InvestmentOperationDO;

@Mapper
public interface InvestmentOperationDAO extends CommonCountMapper, CommonInsertMapper<InvestmentOperationDO>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.298004+08:00", comments="Source Table: investment_operation")
    BasicColumn[] selectList = BasicColumn.columnList(id, isDeleted, createTime, updateTime, opDate, opPlatform, opType, opItem, opAmount);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.292879+08:00", comments="Source Table: investment_operation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="InvestmentOperationDOResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.BIT),
        @Result(column="create_time", property="createTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="update_time", property="updateTime", jdbcType=JdbcType.TIMESTAMP),
        @Result(column="op_date", property="opDate", jdbcType=JdbcType.DATE),
        @Result(column="op_platform", property="opPlatform", jdbcType=JdbcType.VARCHAR),
        @Result(column="op_type", property="opType", jdbcType=JdbcType.VARCHAR),
        @Result(column="op_item", property="opItem", jdbcType=JdbcType.VARCHAR),
        @Result(column="op_amount", property="opAmount", jdbcType=JdbcType.VARCHAR)
    })
    List<InvestmentOperationDO> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.294001+08:00", comments="Source Table: investment_operation")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("InvestmentOperationDOResult")
    Optional<InvestmentOperationDO> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.294249+08:00", comments="Source Table: investment_operation")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, investmentOperationDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.295255+08:00", comments="Source Table: investment_operation")
    default int insert(InvestmentOperationDO row) {
        return MyBatis3Utils.insert(this::insert, row, investmentOperationDO, c ->
            c.map(id).toProperty("id")
            .map(isDeleted).toProperty("isDeleted")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(opDate).toProperty("opDate")
            .map(opPlatform).toProperty("opPlatform")
            .map(opType).toProperty("opType")
            .map(opItem).toProperty("opItem")
            .map(opAmount).toProperty("opAmount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.296703+08:00", comments="Source Table: investment_operation")
    default int insertMultiple(Collection<InvestmentOperationDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, investmentOperationDO, c ->
            c.map(id).toProperty("id")
            .map(isDeleted).toProperty("isDeleted")
            .map(createTime).toProperty("createTime")
            .map(updateTime).toProperty("updateTime")
            .map(opDate).toProperty("opDate")
            .map(opPlatform).toProperty("opPlatform")
            .map(opType).toProperty("opType")
            .map(opItem).toProperty("opItem")
            .map(opAmount).toProperty("opAmount")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.297212+08:00", comments="Source Table: investment_operation")
    default int insertSelective(InvestmentOperationDO row) {
        return MyBatis3Utils.insert(this::insert, row, investmentOperationDO, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(isDeleted).toPropertyWhenPresent("isDeleted", row::getIsDeleted)
            .map(createTime).toPropertyWhenPresent("createTime", row::getCreateTime)
            .map(updateTime).toPropertyWhenPresent("updateTime", row::getUpdateTime)
            .map(opDate).toPropertyWhenPresent("opDate", row::getOpDate)
            .map(opPlatform).toPropertyWhenPresent("opPlatform", row::getOpPlatform)
            .map(opType).toPropertyWhenPresent("opType", row::getOpType)
            .map(opItem).toPropertyWhenPresent("opItem", row::getOpItem)
            .map(opAmount).toPropertyWhenPresent("opAmount", row::getOpAmount)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.29849+08:00", comments="Source Table: investment_operation")
    default Optional<InvestmentOperationDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, investmentOperationDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.298788+08:00", comments="Source Table: investment_operation")
    default List<InvestmentOperationDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, investmentOperationDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.299052+08:00", comments="Source Table: investment_operation")
    default List<InvestmentOperationDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, investmentOperationDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.299359+08:00", comments="Source Table: investment_operation")
    default Optional<InvestmentOperationDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.299603+08:00", comments="Source Table: investment_operation")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, investmentOperationDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.299862+08:00", comments="Source Table: investment_operation")
    static UpdateDSL<UpdateModel> updateAllColumns(InvestmentOperationDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(isDeleted).equalTo(row::getIsDeleted)
                .set(createTime).equalTo(row::getCreateTime)
                .set(updateTime).equalTo(row::getUpdateTime)
                .set(opDate).equalTo(row::getOpDate)
                .set(opPlatform).equalTo(row::getOpPlatform)
                .set(opType).equalTo(row::getOpType)
                .set(opItem).equalTo(row::getOpItem)
                .set(opAmount).equalTo(row::getOpAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.300263+08:00", comments="Source Table: investment_operation")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(InvestmentOperationDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(isDeleted).equalToWhenPresent(row::getIsDeleted)
                .set(createTime).equalToWhenPresent(row::getCreateTime)
                .set(updateTime).equalToWhenPresent(row::getUpdateTime)
                .set(opDate).equalToWhenPresent(row::getOpDate)
                .set(opPlatform).equalToWhenPresent(row::getOpPlatform)
                .set(opType).equalToWhenPresent(row::getOpType)
                .set(opItem).equalToWhenPresent(row::getOpItem)
                .set(opAmount).equalToWhenPresent(row::getOpAmount);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.300796+08:00", comments="Source Table: investment_operation")
    default int updateByPrimaryKey(InvestmentOperationDO row) {
        return update(c ->
            c.set(isDeleted).equalTo(row::getIsDeleted)
            .set(createTime).equalTo(row::getCreateTime)
            .set(updateTime).equalTo(row::getUpdateTime)
            .set(opDate).equalTo(row::getOpDate)
            .set(opPlatform).equalTo(row::getOpPlatform)
            .set(opType).equalTo(row::getOpType)
            .set(opItem).equalTo(row::getOpItem)
            .set(opAmount).equalTo(row::getOpAmount)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2026-01-11T14:44:30.301137+08:00", comments="Source Table: investment_operation")
    default int updateByPrimaryKeySelective(InvestmentOperationDO row) {
        return update(c ->
            c.set(isDeleted).equalToWhenPresent(row::getIsDeleted)
            .set(createTime).equalToWhenPresent(row::getCreateTime)
            .set(updateTime).equalToWhenPresent(row::getUpdateTime)
            .set(opDate).equalToWhenPresent(row::getOpDate)
            .set(opPlatform).equalToWhenPresent(row::getOpPlatform)
            .set(opType).equalToWhenPresent(row::getOpType)
            .set(opItem).equalToWhenPresent(row::getOpItem)
            .set(opAmount).equalToWhenPresent(row::getOpAmount)
            .where(id, isEqualTo(row::getId))
        );
    }
}