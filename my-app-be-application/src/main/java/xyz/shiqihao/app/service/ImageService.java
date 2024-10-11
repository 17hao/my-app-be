package xyz.shiqihao.app.service;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import jakarta.annotation.Resource;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
import xyz.shiqihao.idgen.IDGenerator;
import xyz.shiqihao.infra.storage.ObjectStorage;

@Component
@Log4j2
public class ImageService {
    @Resource(name = "tencentObjectStorage")
    private ObjectStorage objectStorage;

    public String upload(MultipartFile file) {
        final long maxFileSize = 1024 * 1024; // 1M
        if (file.getSize() > maxFileSize) {
            // TODO: 异常处理
            throw new RuntimeException("file is too large");
        }
        String fileName = file.getOriginalFilename();
        Set<String> validFileExts = new HashSet<>();
        validFileExts.add("svg");
        validFileExts.add("jpg");
        validFileExts.add("png");
        validFileExts.add("jpng");
        boolean fileExtIsValid = true;
        for (String ext : validFileExts) {
            if (fileName != null && !fileName.endsWith(ext)) {
                fileExtIsValid = false;
                break;
            }
        }
        if (!fileExtIsValid) {
            throw new RuntimeException(String.format("[upload] file extension is invalid, fileName=%s", fileName));
        }
        String key = String.format("/%s/%d", LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE), IDGenerator.gen());
        log.info("[upload] key={}", key);

        Path path = Paths.get("/var/tmp", key);
        try (OutputStream os = Files.newOutputStream(path)) {
            os.write(file.getBytes());
        } catch (IOException e) {
            log.error("[upload] exception={}", e.getMessage());
            throw new RuntimeException(e);
        }

        return path.getFileName().toString();
        // return objectStorage.put(key, path.toFile());
    }
}
