package xyz.shiqihao.common.util;

import xyz.shiqihao.common.exception.BizException;

public final class AssertUtils {
    public static <T> T isNonNull(T obj) {
        if (obj == null) {
            throw new BizException("1", "obj is null");
        }
        return obj;
    }
}
