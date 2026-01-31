package xyz.shiqihao.common.util;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
@Log4j2
public class JwtUtils {

    private static final String accountIdConst = "accountId";
    private static final String accountNameConst = "accountName";
    private static final String expireAtConst = "expireAt";

    private final String secretKey;

    public JwtUtils(@Value("${jwtSecretKey}") String secretKey) {
        this.secretKey = secretKey;
    }

    private SecretKey loadSecretKey() {
        // https://github.com/jwtk/jjwt?tab=readme-ov-file#secretkey-formats
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretKey));
    }

    public String buildAccountJwt(Long accountId, String accountName) {
        return Jwts.builder()
                .claims()
                .add(accountIdConst, String.valueOf(accountId))
                .add(accountName, accountName)
                .add(expireAtConst, LocalDateTime.now().plusWeeks(1).toString())
                .and()
                .signWith(loadSecretKey())
                .compact();
    }

    public Map<String, String> parseJwt(String token) {
        Claims jwtClaim = Jwts.parser().verifyWith(loadSecretKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();

        Map<String, String> res = new HashMap<>();
        if (jwtClaim.containsKey(accountIdConst)) {
            res.put(accountIdConst, (String) jwtClaim.get(accountIdConst));
        }
        if (jwtClaim.containsKey(accountNameConst)) {
            res.put(accountNameConst, (String) jwtClaim.get(accountNameConst));
        }
        if (jwtClaim.containsKey(expireAtConst)) {
            res.put(expireAtConst, (String) jwtClaim.get(expireAtConst));
        }
        return res;
    }

    private static void generateKey() {
        // https://github.com/jwtk/jjwt?tab=readme-ov-file#secret-keys
        SecretKey secretKey = Jwts.SIG.HS256.key().build();
        String secretStr = Encoders.BASE64URL.encode(secretKey.getEncoded());
        System.out.println(secretStr);
    }

    public static void main(String[] args) {
        generateKey();
    }

}
