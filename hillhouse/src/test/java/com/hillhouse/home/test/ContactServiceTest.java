package com.hillhouse.home.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.doublev2v.foundation.core.model.PagedList;
import com.hillhouse.home.entity.contact.Contact;
import com.hillhouse.home.service.ContactService;

public class ContactServiceTest {
	private static ContactService service;
	private static void init() {
		ClassPathXmlApplicationContext cxt=new ClassPathXmlApplicationContext("applicationContext.xml");
		service=cxt.getBean(ContactService.class);	
	}
	public static void main(String[] args) {	
		init();
		add();
	}
	private static void add() {
		Contact contact=new Contact();
		contact.setEmail("yzdytm@163.com");
		contact.setMessage("你好吗");
		contact.setName("Tim");
		contact.setSubject("工程师");
		service.add(contact);
		System.out.println(contact.getId());
	}
	private static void update() {
		Contact contact=new Contact();
		contact.setId("404040e64ca275ba014ca275bc120000");
		contact.setEmail("yzdytm@163.com");
		contact.setMessage("你好");
		contact.setName("Tim");
		contact.setSubject("工程师");
		service.update(contact);
	}
	private static void get() {
		String id="404040e64c983505014c983513620000";
		Contact contact=service.get(id);
		System.out.println(contact.getSubject());
	}
	private static void getPagedList() {
		PagedList<Contact> contactPagedList=service.getPagedList(null, null);
		System.out.println(contactPagedList.getTotalCount());
	}
	private static void delete() {
		service.delete("");
	}
}
