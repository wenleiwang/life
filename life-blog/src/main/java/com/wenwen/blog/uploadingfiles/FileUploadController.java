package com.wenwen.blog.uploadingfiles;

import com.wenwen.blog.uploadingfiles.storage.FileSystemStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/file")
public class FileUploadController {

    @Autowired
    private FileSystemStorageService storageService;

    @PostMapping("/upload")
    @ResponseBody
    public String handleFileUpload(@RequestParam("file") MultipartFile file) {
        return storageService.store(file);
    }

    @PostMapping("/uploadToQiNiu")
    @ResponseBody
    public String uploadToQiNiu(@RequestParam("file") MultipartFile file) {
        return storageService.uploadToQiNiu(file);
    }

}