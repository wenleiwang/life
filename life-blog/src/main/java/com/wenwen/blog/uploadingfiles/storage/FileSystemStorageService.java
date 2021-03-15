package com.wenwen.blog.uploadingfiles.storage;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileSystemStorageService implements StorageService {
	Logger logger = LoggerFactory.getLogger(FileSystemStorageService.class);
	String accessKey = "62knrQrpddGoaHNkPuYZT35tzsQCTd12vFxm9kmT";
	String secretKey = "mbRKLiJ1RjdhU-uo0_7vhyN0jtukq8-GtSnrweAv";
	String bucket = "poesy";
	String key = null;
	String url = "http://img.poesy.ink/";
	/**地址*/
	private final Path rootLocation = Paths.get("D:/log/data");

	@Override
	public String store(MultipartFile file) {
		Path road = null;
		try {
			if (file.isEmpty()) {
				throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
			}
			road = this.rootLocation.resolve(file.getOriginalFilename());
			Files.copy(file.getInputStream(), road);
		} catch (IOException e) {
			throw new StorageException("Failed to store file " + file.getOriginalFilename(), e);
		}
		return road.toString().replaceAll("\\\\","/");
	}

	@Override
	public String uploadToQiNiu(MultipartFile file) {
		if (file.isEmpty()) {
			throw new StorageException("Failed to store empty file " + file.getOriginalFilename());
		}
		InputStream inputStream = null;
		try {
			inputStream = file.getInputStream();
		} catch (IOException e) {
			e.printStackTrace();
			logger.error("文件转换成输入流失败！",e);
			throw new StorageException("文件转换成输入流失败 " + e.toString());
		}
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
		Configuration cfg = new Configuration(Region.autoRegion());
		UploadManager uploadManager = new UploadManager(cfg);
		DefaultPutRet putRet = null;
		try {
			Response response = uploadManager.put(inputStream,key,upToken,null, null);
			//解析上传成功的结果
			putRet = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
		} catch (QiniuException ex) {
			Response r = ex.response;
			System.err.println(r.toString());
			logger.error(r.toString());
			try {
				System.err.println(r.bodyString());
				logger.error(r.bodyString());
			} catch (QiniuException ex2) {
				//ignore
				logger.error(ex2.error());
			}
		}
		if(putRet != null){
			return url + putRet.key;
		}else{
			throw new StorageException("上传文件失败！" );
		}
	}
}
