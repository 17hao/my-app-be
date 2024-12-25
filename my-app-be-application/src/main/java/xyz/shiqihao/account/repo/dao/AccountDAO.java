package xyz.shiqihao.account.repo.dao;

import static org.mybatis.dynamic.sql.SqlBuilder.isEqualTo;
import static xyz.shiqihao.account.repo.dao.AccountDODynamicSqlSupport.*;

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
import xyz.shiqihao.account.repo.model.AccountDO;

@Mapper
public interface AccountDAO extends CommonCountMapper, CommonInsertMapper<AccountDO>, CommonUpdateMapper {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.498734+08:00", comments="Source Table: account")
    BasicColumn[] selectList = BasicColumn.columnList(id, name, passwordHash, isDeleted);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.494388+08:00", comments="Source Table: account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @Results(id="AccountDOResult", value = {
        @Result(column="id", property="id", jdbcType=JdbcType.BIGINT, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="password_hash", property="passwordHash", jdbcType=JdbcType.VARCHAR),
        @Result(column="is_deleted", property="isDeleted", jdbcType=JdbcType.BIT)
    })
    List<AccountDO> selectMany(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.495313+08:00", comments="Source Table: account")
    @SelectProvider(type=SqlProviderAdapter.class, method="select")
    @ResultMap("AccountDOResult")
    Optional<AccountDO> selectOne(SelectStatementProvider selectStatement);

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.495551+08:00", comments="Source Table: account")
    default long count(CountDSLCompleter completer) {
        return MyBatis3Utils.countFrom(this::count, accountDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.496377+08:00", comments="Source Table: account")
    default int insert(AccountDO row) {
        return MyBatis3Utils.insert(this::insert, row, accountDO, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(passwordHash).toProperty("passwordHash")
            .map(isDeleted).toProperty("isDeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.49759+08:00", comments="Source Table: account")
    default int insertMultiple(Collection<AccountDO> records) {
        return MyBatis3Utils.insertMultiple(this::insertMultiple, records, accountDO, c ->
            c.map(id).toProperty("id")
            .map(name).toProperty("name")
            .map(passwordHash).toProperty("passwordHash")
            .map(isDeleted).toProperty("isDeleted")
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.498058+08:00", comments="Source Table: account")
    default int insertSelective(AccountDO row) {
        return MyBatis3Utils.insert(this::insert, row, accountDO, c ->
            c.map(id).toPropertyWhenPresent("id", row::getId)
            .map(name).toPropertyWhenPresent("name", row::getName)
            .map(passwordHash).toPropertyWhenPresent("passwordHash", row::getPasswordHash)
            .map(isDeleted).toPropertyWhenPresent("isDeleted", row::getIsDeleted)
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.499166+08:00", comments="Source Table: account")
    default Optional<AccountDO> selectOne(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectOne(this::selectOne, selectList, accountDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.499393+08:00", comments="Source Table: account")
    default List<AccountDO> select(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectList(this::selectMany, selectList, accountDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.499616+08:00", comments="Source Table: account")
    default List<AccountDO> selectDistinct(SelectDSLCompleter completer) {
        return MyBatis3Utils.selectDistinct(this::selectMany, selectList, accountDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.499916+08:00", comments="Source Table: account")
    default Optional<AccountDO> selectByPrimaryKey(Long id_) {
        return selectOne(c ->
            c.where(id, isEqualTo(id_))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.500194+08:00", comments="Source Table: account")
    default int update(UpdateDSLCompleter completer) {
        return MyBatis3Utils.update(this::update, accountDO, completer);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.500477+08:00", comments="Source Table: account")
    static UpdateDSL<UpdateModel> updateAllColumns(AccountDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalTo(row::getId)
                .set(name).equalTo(row::getName)
                .set(passwordHash).equalTo(row::getPasswordHash)
                .set(isDeleted).equalTo(row::getIsDeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.500776+08:00", comments="Source Table: account")
    static UpdateDSL<UpdateModel> updateSelectiveColumns(AccountDO row, UpdateDSL<UpdateModel> dsl) {
        return dsl.set(id).equalToWhenPresent(row::getId)
                .set(name).equalToWhenPresent(row::getName)
                .set(passwordHash).equalToWhenPresent(row::getPasswordHash)
                .set(isDeleted).equalToWhenPresent(row::getIsDeleted);
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.501254+08:00", comments="Source Table: account")
    default int updateByPrimaryKey(AccountDO row) {
        return update(c ->
            c.set(name).equalTo(row::getName)
            .set(passwordHash).equalTo(row::getPasswordHash)
            .set(isDeleted).equalTo(row::getIsDeleted)
            .where(id, isEqualTo(row::getId))
        );
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.501596+08:00", comments="Source Table: account")
    default int updateByPrimaryKeySelective(AccountDO row) {
        return update(c ->
            c.set(name).equalToWhenPresent(row::getName)
            .set(passwordHash).equalToWhenPresent(row::getPasswordHash)
            .set(isDeleted).equalToWhenPresent(row::getIsDeleted)
            .where(id, isEqualTo(row::getId))
        );
    }
}