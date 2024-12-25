package xyz.shiqihao.account.repo.model;

import jakarta.annotation.Generated;

public class AccountDO {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.49008+08:00", comments="Source field: account.id")
    private Long id;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491303+08:00", comments="Source field: account.name")
    private String name;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491492+08:00", comments="Source field: account.password_hash")
    private String passwordHash;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491648+08:00", comments="Source field: account.is_deleted")
    private Boolean isDeleted;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491007+08:00", comments="Source field: account.id")
    public Long getId() {
        return id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491237+08:00", comments="Source field: account.id")
    public void setId(Long id) {
        this.id = id;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491366+08:00", comments="Source field: account.name")
    public String getName() {
        return name;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.49144+08:00", comments="Source field: account.name")
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491546+08:00", comments="Source field: account.password_hash")
    public String getPasswordHash() {
        return passwordHash;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491601+08:00", comments="Source field: account.password_hash")
    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash == null ? null : passwordHash.trim();
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491698+08:00", comments="Source field: account.is_deleted")
    public Boolean getIsDeleted() {
        return isDeleted;
    }

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2024-12-25T21:19:46.491751+08:00", comments="Source field: account.is_deleted")
    public void setIsDeleted(Boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}