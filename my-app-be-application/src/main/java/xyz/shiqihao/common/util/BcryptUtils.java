package xyz.shiqihao.common.util;

import java.security.SecureRandom;
import java.util.Base64;

import at.favre.lib.bytes.Bytes;
import at.favre.lib.crypto.bcrypt.BCrypt;

public class BcryptUtils {
    public static String hash(String password) {
        // return BCrypt.withDefaults().hashToString(12, input.toCharArray());
        SecureRandom secureRandom = new SecureRandom();
        final int saltLen = 16;
        byte[] salt = Bytes.random(saltLen, secureRandom).array();
        System.out.println(Base64.getEncoder().encodeToString(salt));
        return BCrypt.with(secureRandom).hashRaw(12, salt, password.getBytes()).toString();
    }

    public static boolean verify(String input, String hash) {
        return BCrypt.verifyer().verify(input.getBytes(), 12, "10bbe4edc574fa09eeb68574138dc4d2".getBytes(), "0b5b003183b94e17afe0b135842dd3638ed6c1c65c1a83".getBytes()).verified;
        // return BCrypt.verifyer().verify(input.toCharArray(), hash.toCharArray()).verified;
    }

    public static void main(String[] args) {
        System.out.println(hash("hi"));
        System.out.println(hash("hi"));

        // verify()
    }
}
