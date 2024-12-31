package xyz.shiqihao.account.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import at.favre.lib.crypto.bcrypt.BCrypt;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.mybatis.dynamic.sql.where.condition.IsEqualTo;
import org.springframework.stereotype.Component;
import redis.clients.jedis.JedisPooled;
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
@Log4j2
public class AccountService {
    private final AccountDAO accountDAO;

    private final JwtUtils jwtUtils;

    private final JedisPooled redisClient;

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

    public String verify(String accountName, String password) {
        Optional<AccountDO> optionalAccountDO = accountDAO.selectOne(c ->
                c.where(name, IsEqualTo.of(accountName)).and(isDeleted, IsEqualTo.of(false))
        );
        if (optionalAccountDO.isEmpty()) {
            throw new AccountException("account name is invalid");
        }
        AccountDO accountDO = optionalAccountDO.get();
        if (BCrypt.verifyer().verify(password.getBytes(), accountDO.getPasswordHash().getBytes()).verified) {
            // String token = jwtUtils.buildJwt(accountDO.getId());
            // redisClient.set(token, accountName);
            return jwtUtils.buildJwt(accountDO.getId(), accountName);
        }
        throw new AccountException("account password is invalid");
    }

    public Boolean auth(String token) {
        Map<String, String> jwtPayload = jwtUtils.parseJwt(token);
        if (!(jwtPayload.containsKey("userId"))) {
            log.error("userId is missing, token={}", token);
            return false;
        }
        if (!(jwtPayload.containsKey("userName"))) {
            log.error("userName is missing, token={}", token);
            return false;
        }
        if (!(jwtPayload.containsKey("expireAt"))) {
            log.error("expireAt is missing, token={}", token);
            return false;
        }
        try {
            LocalDateTime expireAt = LocalDateTime.parse(jwtPayload.get("expireAt"));
            if (expireAt.isBefore(LocalDateTime.now())) {
                return false;
            }
        } catch (DateTimeParseException e) {
            log.error("invalid expireAt format, token={}", token);
            return false;
        }
        String userIdStr = jwtPayload.get("userId");
        String actualUserName = jwtPayload.get("userName");
        Optional<AccountDO> optionalAccountDO = accountDAO.selectByPrimaryKey(Long.parseLong(userIdStr));
        if (optionalAccountDO.isEmpty()) {
            log.error("user not exist, token={}", token);
            return false;
        }
        // String expectedUserName = redisClient.get(userIdStr);
        String expectedUserName = optionalAccountDO.get().getName();
        return Objects.equals(expectedUserName, actualUserName);
    }
}
