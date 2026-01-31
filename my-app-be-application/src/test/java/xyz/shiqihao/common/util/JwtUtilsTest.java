package xyz.shiqihao.common.util;

import org.junit.Assert;
import org.junit.Test;

public class JwtUtilsTest {
    private final JwtUtils jwtUtils = new JwtUtils("afm4HQwGb1nDRd3z_0twUVaoAPYtOiPC7FDOSyDi6dx");

    @Test
    public void buildJwt_case1() {
        String jwt = jwtUtils.buildAccountJwt(1L, "test");
        System.out.println(jwt);
        Assert.assertNotNull(jwt);
    }
}