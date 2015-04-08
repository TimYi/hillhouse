package home;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doublev2v.foundation.test.JpegMultipartFile;
import com.hillhouse.home.entity.figure.Figure;
import com.hillhouse.home.service.FigureService;

public class FigureServiceTest {
	
	private static FigureService service;
	static {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=ctx.getBean(FigureService.class);
	}
	public static void main(String[] args) throws IOException {
		editFigure();
	}
	private static void addFigure() throws IOException {
		Figure figure=new Figure();
		figure.setFirstname("Li");
		figure.setLastname("Lei");
		figure.setFullTitle("Our boss");
		figure.setPriority(1);
		figure.setTitle("boss");
		figure.setSummary("a summary");
		figure.setStory("a long story");
		File file=new File("E:/_Git/hillhouse/new/image/leizhang.jpg");
		JpegMultipartFile avatar=new JpegMultipartFile(file);
		service.addFigure(figure, avatar);
		System.out.println(figure.getId());
	}
	private static void editFigure() throws IOException {
		Figure figure=new Figure();
		figure.setId("404040e64c986060014c986062640001");
		figure.setFirstname("Yi");
		figure.setLastname("Tianming");
		figure.setFullTitle("Our boss");
		figure.setPriority(1);
		figure.setTitle("boss");
		figure.setSummary("a summary");
		figure.setStory("a long story");
		File file=new File("E:/_Git/hillhouse/new/image/leizhang.jpg");
		JpegMultipartFile avatar=new JpegMultipartFile(file);
		service.updateFigure(figure, avatar);
		System.out.println(figure.getLastname());
	}
	private static void deleteFigure() throws IOException {
		service.deleteFigure("404040e64c984a52014c984a54c30001");
	}
	private static void getFigure() {
		Figure figure=service.getFigure("404040e64c984cc6014c984cc9170001");
		System.out.println(figure.getAvatar());
	}
}
