package com.doublev2v.foundation.core.rest;

import java.io.IOException;
import java.text.ParseException;
import java.util.Map;

import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation.Builder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.glassfish.jersey.media.multipart.FormDataBodyPart;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.core.util.JsonSerializer;
import com.fasterxml.jackson.databind.JsonNode;

/**
 * 用于云衣橱数据通信
 * 由于有spring的依赖注入，因此不再需要单例模式
 */
public class Client {
	private javax.ws.rs.client.Client client;
	public Client() {
		client=ClientBuilder.newClient();
		client.register(MultiPartFeature.class);
	}
	
	public JsonNode get(String path) throws IOException {
		String result=getString(path);
		return readTree(result);
	}
	
	public JsonNode get(String path, Map<String, String> params) throws IOException {
		String result=getString(path, params);
		return readTree(result);
	}
	
	public JsonNode post(String path, Map<String, String> params) throws IOException {
		String result=postString(path, params);
		return readTree(result);
	}
	
	public JsonNode post(String path, Map<String,String> params, Map<String, MultipartFile> files) throws IOException,ParseException {
		String result=postString(path, params, files);
		return readTree(result);
	}
	
	protected JsonNode readTree(String content) throws IOException {
		JsonNode node=JsonSerializer.readTree(content);
		return node;
	}
	
	public String getString(String path) {
		WebTarget target=client.target(path);
		Builder invocationBuilder=target.request();
		Response response=invocationBuilder.get();
		String result=response.readEntity(String.class);
		return result;
	}
	
	public String getString(String path, Map<String, String> params) {
		WebTarget target=client.target(path);
		for (String key : params.keySet()) {
			target=target.queryParam(key, params.get(key));
		}
		Builder invocationBuilder=target.request();
		Response response=invocationBuilder.get();
		String result=response.readEntity(String.class);
		return result;
	}
	
	public String postString(String path, Map<String, String> params) {
		WebTarget target=client.target(path);
		Form form=new Form();
		for (String key : params.keySet()) {
			form.param(key, params.get(key));
		}
		Builder invocationBuilder=target.request();
		Response response=invocationBuilder.post(Entity.entity(form, MediaType.APPLICATION_FORM_URLENCODED_TYPE));
		String result=response.readEntity(String.class);
		return result;
	}
	
	public String postString(String path, Map<String, String> params, Map<String, MultipartFile> files) throws IOException,ParseException {
		WebTarget target=client.target(path);
		FormDataMultiPart multiPart=new FormDataMultiPart();
		for (String key : params.keySet()) {
			multiPart.field(key, params.get(key));
		}
		for (String key : files.keySet()){
			MultipartFile file=files.get(key);
			if(!file.isEmpty()) {
				String filename=file.getOriginalFilename();
				String contentType=file.getContentType();
				FormDataBodyPart fdp=new FormDataBodyPart(key, file.getBytes(), MediaType.valueOf(contentType));
				FormDataContentDisposition disposition;
				String dispositionString="form-data;name="+key+";filename="+filename;
				disposition=new FormDataContentDisposition(dispositionString);
				fdp.contentDisposition(disposition);
				multiPart.bodyPart(fdp);
			}				
		}
		Builder invocationBuilder=target.request();
		Response response=invocationBuilder.post(Entity.entity(multiPart, multiPart.getMediaType()));
		String result=response.readEntity(String.class);
		return result;
	}
}
