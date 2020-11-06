package com.wenwen.blog.uploadingfiles.storage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.FileSystemUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class FileSystemStorageService implements StorageService {

	/**地址*/
	private final Path rootLocation = Paths.get("D:/log/data");
//
//	@Autowired
//	public FileSystemStorageService(StorageProperties properties) {
//		this.rootLocation = Paths.get(properties.getLocation());
//	}

	@Override
	public void store(MultipartFile file) {
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
			}
			Files.copy(file.getInputStream(), this.rootLocation.resolve(file.getOriginalFilename()));
		} catch (IOException e) {
			throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
		}
	}

	@Override
	public Stream<Path> loadAll() {
		try {
			return Files.walk(this.rootLocation, 1)
					.filter(path -> !path.equals(this.rootLocation))
					.map(path -> this.rootLocation.relativize(path));
		} catch (IOException e) {
			throw new StorageException("Failed to read stored files", e);
		}

	}

	@Override
	public Path load(String filename) {
		return rootLocation.resolve(filename);
	}

	@Override
	public Resource loadAsResource(String filename) {
		try {
			Path file = load(filename);
			Resource resource = new UrlResource(file.toUri());
			if(resource.exists() || resource.isReadable()) {
				return resource;
			}
			else {
				throw new StorageFileNotFoundException("Could not read file: " + filename);

			}
		} catch (MalformedURLException e) {
			throw new StorageFileNotFoundException("Could not read file: " + filename, e);
		}
	}

	@Override
	public void deleteAll() {
		FileSystemUtils.deleteRecursively(rootLocation.toFile());
	}

	@Override
	public void init() {

//			ClassLoader.getSystemResourceAsStream()
		try {
			Files.createDirectory(rootLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}
//			ClassPathResource classPathResource = new ClassPathResource("com/wenwen/life_blog/uploadingfiles/data" );
//			classPathResource.createRelative("/data");

//			URL systemResource = ClassLoader.getSystemResource("");
//			System.out.println(systemResource.getPath());
//			URL systemResource2 = ClassLoader.getSystemResource("");
//			System.out.println(systemResource2.getPath());
//			URL resource = FileSystemStorageService.class.getResource("/");
//			URL resource2 = FileSystemStorageService.class.getResource("");
//			System.out.println(resource.getPath());
//			System.out.println(resource2.getPath());
	}
}
