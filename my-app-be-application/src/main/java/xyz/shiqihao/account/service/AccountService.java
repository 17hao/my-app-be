package xyz.shiqihao.account.service;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AllArgsConstructor;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.stereotype.Component;
import xyz.shiqihao.account.repo.dao.AccountDAO;
import xyz.shiqihao.account.repo.model.AccountDO;
import xyz.shiqihao.common.IDGenerator;

import static xyz.shiqihao.account.repo.dao.AccountDODynamicSqlSupport.id;
import static xyz.shiqihao.account.repo.dao.AccountDODynamicSqlSupport.name;

@Component
@AllArgsConstructor
public class AccountService {
    private final AccountDAO accountDAO;

    public String verify(long accountId, String password) {
        AccountDO accountDO = accountDAO.selectOne(c -> c.where(id, IsEqualTo.of(accountId))).orElseThrow();
        if (BCrypt.verifyer().verify(password.getBytes(), accountDO.getPasswordHash().getBytes()).verified) {
            return "true";
        }
        return "false";
    }

    public String verify(String accountName, String password) {
        AccountDO accountDO = accountDAO.selectOne(c -> c.where(name, IsEqualTo.of(accountName))).orElseThrow();
        if (BCrypt.verifyer().verify(password.getBytes(), accountDO.getPasswordHash().getBytes()).verified) {
            return "true";
        }
        return "false";
    }

    public long register(String name, String password) {
        AccountDO accountDO = new AccountDO();
        accountDO.setId(IDGenerator.gen());
        accountDO.setName(name);

        // SecureRandom secureRandom = new SecureRandom();
        // final int saltLen = 16;
        // byte[] salt = Bytes.random(saltLen, secureRandom).array();
        // accountDO.setPasswordSalt(new String(salt));
        accountDO.setPasswordHash(BCrypt.withDefaults().hashToString(12, password.toCharArray()));
        accountDO.setDeleted(false);
        accountDAO.insert(accountDO);
        return accountDO.getId();
    }
}
