package com.doublev2v.foundation.media;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.core.repository.BaseModelRepository;

/**
 * 文件保存在服务器本地磁盘时，可以使用此媒体仓库。
 * @author pc
 *
 */
@Transactional
public class LocalMediaService implements MediaService {
	
	@Autowired
	private BaseModelRepository<MediaContent, String> repository;
	
	private String serverName;
	private String serverAddress;
	private String basePath;
	private String relativePath="/image/";
	
	@Override
	public MediaContent getMedia(String id) {
		return repository.getItem(id);
	}
	@Override
	public MediaContent save(MultipartFile file) throws IOException {
		MediaContent media=null;
		return update(media, file);
	}

	@Override
	public MediaContent update(MediaContent media, MultipartFile file) throws IOException {
		//根据文件内容，生成MediaContent		
		Validate.notNull(file);
		if(media==null) {
			media=new MediaContent();
		} else {
			//清理旧文件
			deleteFile(media);
		}
		media.setServerAddress(getServerAddress());
		media.setFileSize(file.getSize());
		media.setServerName(serverName);
		media.setContentType(file.getContentType());
		String originFileName=file.getOriginalFilename();
		media.setOriginFileName(originFileName);
		String extension=FilenameUtils.getExtension(originFileName);
		String fileName=UUID.randomUUID().toString();
		fileName=fileName+"."+extension;
		//相对根路径的path
		String relativePath=getRelativePath(extension);
		String path=FilenameUtils.normalize(relativePath+fileName, true);
		media.setFileName(fileName);
		media.setPath(path);
		//将文件保存到本地目录
		String realFilePath=FilenameUtils.normalize(getBasePath()+path, true);
		File realFile=new File(realFilePath);
		FileUtils.writeByteArrayToFile(realFile, file.getBytes());
		repository.saveOrUpdate(media);
		return media;
	}
	
	@Override
	public MediaContent update(String id, MultipartFile file)
			throws IOException {
		MediaContent media=repository.getItem(id);
		Validate.notNull(media);
		return update(media, file);
	}
	
	@Override
	public void delete(MediaContent media) throws IOException {
		if(media==null)return;
		deleteFile(media);
		repository.delete(media);
	}
	@Override
	public void delete(String id) throws IOException {
		MediaContent media=repository.getItem(id);
		delete(media);
	}
	
	protected void deleteFile(MediaContent media) {
		String path=getBasePath()+media.getPath();
		path=FilenameUtils.normalize(path, true);
		File file=new File(path);
		file.delete();
	}
	
	/**
	 * 根据文件扩展名返回相对路径，比如.jpg结尾返回/images文件夹
	 * @param extension
	 * @return
	 * @throws IOException
	 */
	protected String getRelativePath(String extension) throws IOException {
		return this.relativePath;
	}

	/**
	 * @return the serverAddress
	 * 服务器地址
	 */
	public String getServerAddress() {
		return serverAddress;
	}

	/**
	 * @param serverAddress the serverAddress to set
	 */
	public void setServerAddress(String serverAddress) {
		this.serverAddress = serverAddress;
	}

	/**
	 * @return the serverName
	 * 服务器名称，用于数据检索和数据迁移
	 */
	public String getServerName() {
		return serverName;
	}

	/**
	 * @param serverName the serverName to set
	 */
	public void setServerName(String serverName) {
		this.serverName = serverName;
	}
	
	
	/**
	 * @return the basePath
	 */
	public String getBasePath() {
		return basePath;
	}

	/**
	 * @param basePath the basePath to set
	 */
	public void setBasePath(String basePath) {
		this.basePath = basePath;
	}

	/**
	 * @return the relativePath
	 * 相对于文件服务器应用跟路径的相对路径，开头带/，结尾带/
	 */
	public String getRelativePath() {
		return relativePath;
	}

	/**
	 * @param relativePath the relativePath to set
	 */
	public void setRelativePath(String relativePath) {
		if(StringUtils.isEmpty(relativePath))return;
		this.relativePath = relativePath;
	}
}
