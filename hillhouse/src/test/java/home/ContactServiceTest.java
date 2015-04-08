package home;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hillhouse.home.entity.contact.Contact;
import com.hillhouse.home.service.ContactService;

public class ContactServiceTest {
	private static ContactService service;
	static {
		ApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=cxt.getBean(ContactService.class);
	}
	public static void main(String[] args) {
		getContact();
	}
	private static void addContact() {
		Contact contact=new Contact();
		contact.setEmail("yzdytm@163.com");
		contact.setMessage("你好");
		contact.setName("Tim");
		contact.setSubject("工程师");
		service.addContact(contact);
		System.out.println(contact.getId());
	}
	private static void getContact() {
		String id="404040e64c983505014c983513620000";
		Contact contact=service.getContact(id);
		System.out.println(contact.getSubject());
	}
}
