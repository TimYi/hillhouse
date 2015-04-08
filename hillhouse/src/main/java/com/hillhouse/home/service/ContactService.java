package com.hillhouse.home.service;

import org.apache.commons.lang.Validate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.doublev2v.foundation.model.PagedList;
import com.hillhouse.home.entity.contact.Contact;
import com.hillhouse.home.entity.contact.ContactRepository;

@Service
public class ContactService {
	@Autowired
	private ContactRepository repository;
	
	public void addContact(Contact contact) {
		Validate.notNull(contact);
		repository.save(contact);
	}
	public PagedList<Contact> getList(Integer pageNo, Integer pageSize) {
		return repository.getPagedList(pageNo, pageSize);
	}
	public Contact getContact(String id) {
		return repository.getItem(id);
	}
}
