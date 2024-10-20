package xyz.shiqihao.account.repo.dao;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class AccountDODynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.632857+08:00", comments="Source Table: account")
    public static final AccountDO accountDO = new AccountDO();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.633139+08:00", comments="Source field: account.id")
    public static final SqlColumn<Long> id = accountDO.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.633405+08:00", comments="Source field: account.name")
    public static final SqlColumn<String> name = accountDO.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.633498+08:00", comments="Source field: account.password_hash")
    public static final SqlColumn<String> passwordHash = accountDO.passwordHash;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.633597+08:00", comments="Source field: account.deleted")
    public static final SqlColumn<Boolean> deleted = accountDO.deleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.633024+08:00", comments="Source Table: account")
    public static final class AccountDO extends AliasableSqlTable<AccountDO> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> passwordHash = column("password_hash", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> deleted = column("deleted", JDBCType.BIT);

        public AccountDO() {
            super("account", AccountDO::new);
        }
    }
}