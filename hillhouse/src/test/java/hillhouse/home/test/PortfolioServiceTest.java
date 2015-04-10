package hillhouse.home.test;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doublev2v.foundation.test.JpegMultipartFile;
import com.hillhouse.home.base.LanguageModel.Language;
import com.hillhouse.home.entity.portfolio.dto.PortfolioDTO;
import com.hillhouse.home.service.PortfolioService;

public class PortfolioServiceTest {
	private static PortfolioService service;
	static {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=ctx.getBean(PortfolioService.class);
	}
	public static void main(String[] args) throws IOException {
		//update();
	}
	/*
	public static void add() {
		PortfolioDTO portfolio=new PortfolioDTO();
		portfolio.setLink("http://www.baidu.com");
		File file=new File("E:/_Git/hillhouse/new/image/baidu.png");
		JpegMultipartFile img=new JpegMultipartFile(file);
		portfolio.setMedia(img);
		portfolio.setLanguage(Language.EN);
		portfolio=service.add(portfolio);
		System.out.println(portfolio.getId());
	}

	public static void update() throws IOException {
		PortfolioDTO portfolio=new PortfolioDTO();
		portfolio.setId("404040e64c9d6563014c9d6566450001");
		portfolio.setLink("http://www.baidu.com");
		File file=new File("E:/_Git/hillhouse/new/image/baidu.png");
		JpegMultipartFile url=new JpegMultipartFile(file);
		portfolio.setMedia(url);
		portfolio.setLanguage(Language.EN);
		portfolio=service.update(portfolio);
	}*/
}
