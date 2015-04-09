package hillhouse.home.test;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doublev2v.foundation.test.JpegMultipartFile;
import com.hillhouse.home.entity.portfolio.Portfolio;
import com.hillhouse.home.service.PortfolioService;

public class PortfolioServiceTest {
	private static PortfolioService service;
	static {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=ctx.getBean(PortfolioService.class);
	}
	public static void main(String[] args) throws IOException {
		updatePortfolio();
	}
	public static void addPortfolio() throws IOException {
		Portfolio portfolio=new Portfolio();
		portfolio.setLink("http://www.baidu.com");
		File file=new File("E:/_Git/hillhouse/new/image/baidu.png");
		JpegMultipartFile img=new JpegMultipartFile(file);
		service.addPortfolio(portfolio, img);
	}
	public static void updatePortfolio() throws IOException {
		Portfolio portfolio=new Portfolio();
		portfolio.setId("404040e64c988e8e014c988e90b10001");
		portfolio.setLink("http://www.baidu.com");
		File file=new File("E:/_Git/hillhouse/new/image/baidu.png");
		JpegMultipartFile url=new JpegMultipartFile(file);
		service.updatePortfolio(portfolio, url);
	}
}
