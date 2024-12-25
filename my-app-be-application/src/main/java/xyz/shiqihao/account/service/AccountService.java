package xyz.shiqihao.account.service;

import java.util.List;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AllArgsConstructor;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.stereotype.Component;
import xyz.shiqihao.account.repo.dao.AccountDAO;
import xyz.shiqihao.account.repo.model.AccountDO;
import xyz.shiqihao.common.IDGenerator;
import xyz.shiqihao.common.exception.BizException;

import static xyz.shiqihao.account.repo.dao.AccountDODynamicSqlSupport.isDeleted;
import static xyz.shiqihao.account.repo.dao.AccountDODynamicSqlSupport.name;

@Component
@AllArgsConstructor
public class AccountService {
    private final AccountDAO accountDAO;

    public String verify(String accountName, String password) {
        AccountDO accountDO = accountDAO.selectOne(c ->
                c.where(name, IsEqualTo.of(accountName)).and(isDeleted, IsEqualTo.of(false))
        ).orElseThrow();
        if (BCrypt.verifyer().verify(password.getBytes(), accountDO.getPasswordHash().getBytes()).verified) {
            return "true";
        }
        return "false";
    }

    public long register(String accountName, String password) {
        List<AccountDO> accountDOList = accountDAO.select(c ->
                c.where(name, IsEqualTo.of(accountName)).and(isDeleted, IsEqualTo.of(false))
        );
        if (accountDOList.size() > 0) {
            throw new BizException("RESOURCE_EXISTS", "account already exists");
        }

        AccountDO accountDO = new AccountDO();
        accountDO.setId(IDGenerator.gen());
        accountDO.setName(accountName);

        accountDO.setPasswordHash(BCrypt.withDefaults().hashToString(12, password.toCharArray()));
        accountDO.setIsDeleted(false);
        accountDAO.insert(accountDO);
        return accountDO.getId();
    }
}
