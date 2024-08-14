package xyz.shiqihao.app.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import xyz.shiqihao.app.service.ImageService;

@RestController
public class FileController {
    private final ImageService imageService;

    @Autowired
    public FileController(ImageService imageService) {
        this.imageService = imageService;
    }

    @PostMapping("/upload-image")
    public Map<String, String> uploadImage(@RequestParam("file") MultipartFile file) {
        Map<String, String> map = new HashMap<>();
        map.put("url", imageService.upload(file));
        return map;
    }
}
