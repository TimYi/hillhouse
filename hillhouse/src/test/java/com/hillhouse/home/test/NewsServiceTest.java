package com.hillhouse.home.test;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doublev2v.foundation.core.model.PagedList;
import com.doublev2v.foundation.test.JpegMultipartFile;
import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.entity.news.News;
import com.hillhouse.home.entity.news.dto.NewsDTO;
import com.hillhouse.home.service.NewsService;

public class NewsServiceTest {

	private static NewsService service;
	static {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=ctx.getBean(NewsService.class);
	}
	public static void main(String[] args) throws IOException {
		add();
	}
	private static void add() {
		NewsDTO news=new NewsDTO();
		news.setAuthor("易天明");
		news.setSummary("总结性文字");
		news.setOrigion("新闻来源");
		news.setTitle("标题");
		news.setType("test");
		news.setLanguage(Language.CH);
		File file=new File("E:/_Git/hillhouse/new/image/news.JPG");
		JpegMultipartFile img=new JpegMultipartFile(file);
		news.setMedia(img);
		service.add(news);
		System.out.println(news.getId());
	}
	/*
	private static void addNews() throws IOException {
		News news=new News();
		news.setAuthor("易天明");
		news.setSummary("总结性文字");
		news.setOrigion("新闻来源");
		news.setTitle("标题");
		news.setType("test");
		news.setLanguage(Language.CH);
		File file=new File("E:/_Git/hillhouse/new/image/news.JPG");
		JpegMultipartFile img=new JpegMultipartFile(file);
		service.addNews(news, img);
		System.out.println(news.getId());
	}
	private static void updateNews() throws IOException {
		News news=new News();
		news.setId("404040e64c98875e014c988760c60001");
		news.setAuthor("易天明");
		news.setSummary("总结性文字");
		news.setOrigion("新闻来源");
		news.setTitle("标题");
		File file=new File("E:/_Git/hillhouse/new/image/news.JPG");
		JpegMultipartFile img=new JpegMultipartFile(file);
		service.updateNews(news, img);
	}
	private static void getList() {
		PagedList<News> list=service.getList(null, null,Language.EN);
		System.out.println(list.getTotalCount());
	}*/
}
