package com.blog.service;

import com.blog.entity.Contact;
import com.blog.repository.contactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class contactService {
    @Autowired
    contactRepository contactRepository;

    public Contact create(Contact contact){
        return contactRepository.save(contact);
    }

    public List<Contact> getAllContact(){
        return contactRepository.findAll();
    }
}
