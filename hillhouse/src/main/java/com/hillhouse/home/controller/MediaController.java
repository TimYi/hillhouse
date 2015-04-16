package com.hillhouse.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.doublev2v.foundation.media.MediaContent;
import com.doublev2v.foundation.media.MediaService;

@Controller
public class MediaController {
	@Autowired
	private MediaService service;
	
	@RequestMapping("/upload")
	public @ResponseBody String upload(@RequestParam MultipartFile imgFile) {
		UploadResult result;
		try {
			MediaContent media=service.save(imgFile);
			result=UploadResult.successResult(media.getUrl());
		} catch (Exception e) {
			result=UploadResult.failResult(e.getMessage());
		}
		return result.toJson();
	}
}
