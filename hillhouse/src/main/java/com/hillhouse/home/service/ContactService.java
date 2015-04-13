package com.hillhouse.home.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.doublev2v.foundation.updatable.UpdatableService;
import com.hillhouse.home.entity.contact.Contact;

@Transactional
@Service
public class ContactService extends UpdatableService<String, Contact> {	
}