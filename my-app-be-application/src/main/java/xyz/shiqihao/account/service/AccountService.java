package xyz.shiqihao.account.service;

import java.util.List;
import java.util.Optional;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AllArgsConstructor;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.stereotype.Component;
import xyz.shiqihao.account.repo.dao.AccountDAO;
import xyz.shiqihao.account.repo.model.AccountDO;
import xyz.shiqihao.common.IDGenerator;
import xyz.shiqihao.common.exception.AccountException;
import xyz.shiqihao.common.exception.BizException;
import xyz.shiqihao.common.util.JwtUtils;

import static xyz.shiqihao.account.repo.dao.AccountDODynamicSqlSupport.isDeleted;
import static xyz.shiqihao.account.repo.dao.AccountDODynamicSqlSupport.name;

@Component
@AllArgsConstructor
public class AccountService {
    private final AccountDAO accountDAO;

    private final JwtUtils jwtUtils;

    public String verify(String accountName, String password) {
        Optional<AccountDO> optionalAccountDO = accountDAO.selectOne(c ->
                c.where(name, IsEqualTo.of(accountName)).and(isDeleted, IsEqualTo.of(false))
        );
        if (optionalAccountDO.isEmpty()) {
            throw new AccountException("account name is invalid");
        }
        AccountDO accountDO = optionalAccountDO.get();
        if (BCrypt.verifyer().verify(password.getBytes(), accountDO.getPasswordHash().getBytes()).verified) {
            return jwtUtils.buildJwt(accountDO.getId());
        }
        throw new AccountException("account password is invalid");
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
