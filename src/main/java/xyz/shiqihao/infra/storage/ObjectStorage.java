package xyz.shiqihao.infra.storage;

import java.io.File;

public interface ObjectStorage {
    void put(String key, File content);
}
