package xyz.shiqihao.app.util;

import java.io.IOException;
import java.util.Properties;

import javax.crypto.SecretKey;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.io.Encoders;
import io.jsonwebtoken.security.Keys;
import xyz.shiqihao.infra.storage.TencentObjectStorage;

public class JwtUtil {
    private static Properties CONF = new Properties();

    static {
        try {
            CONF.load(TencentObjectStorage.class.getResourceAsStream("/jwt-key.properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static SecretKey generateKey() {
        // https://github.com/jwtk/jjwt?tab=readme-ov-file#secret-keys
        SecretKey secretKey = Jwts.SIG.HS256.key().build();
        String secretStr = Encoders.BASE64URL.encode(secretKey.getEncoded());
        System.out.println(secretStr);
        return secretKey;
    }

    private static SecretKey loadKey() {
        // https://github.com/jwtk/jjwt?tab=readme-ov-file#secretkey-formats
        String secretStr = CONF.getProperty("secretStr");
        return Keys.hmacShaKeyFor(Decoders.BASE64URL.decode(secretStr));
    }

    public static String of(Long userId) {
        return Jwts.builder()
                .claims().add("userId", userId).and()
                .signWith(loadKey())
                .compact();
    }

    public static boolean verify(String jwt, long targetUserId) {
        Claims jwtClaim = Jwts.parser().verifyWith(loadKey()).build().parseSignedClaims(jwt).getPayload();
        long parsedUserId = (long) jwtClaim.get("userId");
        System.out.println(jwtClaim.get("userId"));
        return targetUserId == parsedUserId;
    }

    public static void main(String[] args) {
        // generateKey();
        // System.out.println(JwtUtil.of(4242732357447163905L));
        System.out.println(JwtUtil.verify("eyJhbGciOiJIUzI1NiJ9.eyJ1c2VySWQiOjQyNDI3MzIzNTc0NDcxNjM5MDV9.KBXF2bNRqn3QguIDOTLZx-Q6-Hxt2DiYwcV9WCKHLsE", 4242732357447163905L));
    }
}
