package com.hillhouse.home.service;

import org.springframework.stereotype.Service;

import com.doublev2v.foundation.updatable.UpdatableService;
import com.hillhouse.home.entity.contact.Contact;

@Service
public class ContactService extends UpdatableService<String, Contact> {

}
