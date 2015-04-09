package hillhouse.home.test;

import java.io.File;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doublev2v.foundation.test.JpegMultipartFile;
import com.hillhouse.home.entity.story.Story;
import com.hillhouse.home.service.StoryService;

public class StoryServiceTest {
	private static StoryService service;
	static {
		ApplicationContext ctx=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=ctx.getBean(StoryService.class);
	}
	public static void main(String[] args) throws IOException {
		updateStory();
	}
	private static void addStory() throws IOException {
		Story story=new Story();
		story.setContent("a long long story");
		story.setSummary("a summary");
		story.setTitle("title");
		File file=new File("E:/_Git/hillhouse/new/image/cc.jpg");
		JpegMultipartFile img=new JpegMultipartFile(file);
		service.addStory(story, img);
	}
	private static void updateStory() throws IOException {
		Story story=new Story();
		story.setId("404040e64c9895d2014c9895d4be0001");
		story.setContent("a long long story");
		story.setSummary("a summary");
		story.setTitle("title");
		File file=new File("E:/_Git/hillhouse/new/image/cc.jpg");
		JpegMultipartFile img=new JpegMultipartFile(file);
		service.updateStory(story, img);
	}	
}
