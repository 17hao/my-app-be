package xyz.shiqihao.common.storage;

import java.io.File;

public interface ObjectStorage {
    /**
     * @return object storage url
     */
    String put(String key, File content);
}
