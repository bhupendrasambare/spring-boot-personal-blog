package com.blog.repository;

import com.blog.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface contactRepository extends JpaRepository<Contact,Integer> {
}
