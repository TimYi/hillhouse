package com.hillhouse.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hillhouse.home.entity.contact.Contact;
import com.hillhouse.home.service.ContactService;

@Controller
public class TestController {
	@Autowired
	private ContactService contactService;
	
	@RequestMapping("/")
	public String test() {
		Contact contact=new Contact();
		contact.setEmail("yzdytm@163.com");
		contact.setMessage("你好吗");
		contact.setName("Tim");
		contact.setSubject("工程师");
		contactService.add(contact);
		return null;
	}
}
