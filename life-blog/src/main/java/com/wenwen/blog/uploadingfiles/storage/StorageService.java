package com.wenwen.blog.uploadingfiles.storage;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.nio.file.Path;
import java.util.stream.Stream;

public interface StorageService {
	String store(MultipartFile file);

	String uploadToQiNiu(MultipartFile file);
}