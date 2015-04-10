package com.hillhouse.home.test;

import java.io.File;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.test.JpegMultipartFile;
import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.entity.figure.dto.FigureDTO;
import com.hillhouse.home.service.FigureService;

public class FigureServiceTest {
	
	private static FigureService service;
	private static void init() {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=ctx.getBean(FigureService.class);
	}
	public static void main(String[] args) {
		init();
		update();
	}
	private static void add() {
		FigureDTO figure=new FigureDTO();
		figure.setFirstname("Li");
		figure.setLastname("Lei");
		figure.setFullTitle("Our boss");
		figure.setPriority(1);
		figure.setTitle("boss");
		figure.setSummary("a summary");
		figure.setStory("a long story");
		figure.setLanguage(Language.EN);
		File file=new File("E:/_Git/hillhouse/new/image/leizhang.jpg");
		JpegMultipartFile avatar=new JpegMultipartFile(file);
		figure.setMedia(avatar);
		figure=service.add(figure);
		System.out.println(figure.getId());
	}

	private static void update() {
		FigureDTO figure=new FigureDTO();
		figure.setId("404040e64ca27e66014ca27e76160001");
		figure.setFirstname("Yi");
		figure.setLastname("Tianming");
		figure.setFullTitle("Our boss");
		figure.setPriority(1);
		figure.setTitle("boss");
		figure.setSummary("a summary");
		figure.setStory("a long story");
		figure.setLanguage(Language.EN);
		File file=new File("E:/_Git/hillhouse/new/image/leizhang.jpg");
		JpegMultipartFile avatar=new JpegMultipartFile(file);
		figure.setMedia(avatar);
		service.update(figure);
		System.out.println(figure.getLastname());
	}
	
	private static void get() {
		FigureDTO figure=service.get("404040e64c9d4c12014c9d4c150f0001");
		System.out.println(figure.getAvatar());
	}
	private static void getPagedList() {
		PagedList<FigureDTO> list=service.getPagedList(null, null, Language.CH);
		System.out.println(list.getTotalCount());
	}
	private static void delete() {
		service.delete("404040e64c9d4c12014c9d4c150f0001");
	}
}
