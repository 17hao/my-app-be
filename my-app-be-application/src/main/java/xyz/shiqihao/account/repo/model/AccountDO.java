package xyz.shiqihao.account.repo.model;

import jakarta.annotation.Generated;

public class AccountDO {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.62953+08:00", comments="Source field: account.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.630722+08:00", comments="Source field: account.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.630919+08:00", comments="Source field: account.password_hash")
    private String passwordHash;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.631071+08:00", comments="Source field: account.deleted")
    private Boolean deleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.630432+08:00", comments="Source field: account.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.630654+08:00", comments="Source field: account.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.630785+08:00", comments="Source field: account.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.630867+08:00", comments="Source field: account.name")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.630971+08:00", comments="Source field: account.password_hash")
    public String getPasswordHash() {
        return passwordHash;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.631024+08:00", comments="Source field: account.password_hash")
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash == null ? null : passwordHash.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.631122+08:00", comments="Source field: account.deleted")
    public Boolean getDeleted() {
        return deleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-10-19T20:12:15.631173+08:00", comments="Source field: account.deleted")
    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
    }
}