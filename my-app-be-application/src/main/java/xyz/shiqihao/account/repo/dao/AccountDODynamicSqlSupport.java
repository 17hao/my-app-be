package xyz.shiqihao.account.repo.dao;

import jakarta.annotation.Generated;
import java.sql.JDBCType;
import org.mybatis.dynamic.sql.AliasableSqlTable;
import org.mybatis.dynamic.sql.SqlColumn;

public final class AccountDODynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.49326+08:00", comments="Source Table: account")
    public static final AccountDO accountDO = new AccountDO();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.493536+08:00", comments="Source field: account.id")
    public static final SqlColumn<Long> id = accountDO.id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.493802+08:00", comments="Source field: account.name")
    public static final SqlColumn<String> name = accountDO.name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.493897+08:00", comments="Source field: account.password_hash")
    public static final SqlColumn<String> passwordHash = accountDO.passwordHash;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.494009+08:00", comments="Source field: account.is_deleted")
    public static final SqlColumn<Boolean> isDeleted = accountDO.isDeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.493424+08:00", comments="Source Table: account")
    public static final class AccountDO extends AliasableSqlTable<AccountDO> {
        public final SqlColumn<Long> id = column("id", JDBCType.BIGINT);

        public final SqlColumn<String> name = column("name", JDBCType.VARCHAR);

        public final SqlColumn<String> passwordHash = column("password_hash", JDBCType.VARCHAR);

        public final SqlColumn<Boolean> isDeleted = column("is_deleted", JDBCType.BIT);

        public AccountDO() {
            super("account", AccountDO::new);
        }
    }
}