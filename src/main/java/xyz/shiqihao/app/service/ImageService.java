package xyz.shiqihao.app.service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import xyz.shiqihao.idgen.IDGenerator;
import xyz.shiqihao.infra.storage.ObjectStorage;

@Component
public class ImageService {
    private static final Logger LOGGER = LogManager.getLogger();

    @Resource(name = "tencentObjectStorage")
    private ObjectStorage objectStorage;

    public String upload(MultipartFile file) {
        final long maxFileSize = 1024 * 1024; // 1M
        if (file.getSize() > maxFileSize) {
            // TODO: 异常处理
            throw new RuntimeException("file is too large");
        }

        String key = String.format("/%s/%d", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE), IDGenerator.gen());
        LOGGER.info("upload key={}", key);

        Path path = Paths.get("/var/tmp", key);
        try (OutputStream os = Files.newOutputStream(path)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            LOGGER.error("upload exception={}", e.getMessage());
            throw new RuntimeException(e);
        }

        return path.getFileName().toString();
        // return objectStorage.put(key, path.toFile());
    }
}
