package com.blog.repository;

import com.blog.entity.Request;
import org.springframework.data.jpa.repository.JpaRepository;

public interface requestRepository extends JpaRepository<Request,Integer> {
}
