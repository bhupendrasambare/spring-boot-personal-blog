package com.blog.repository;

import com.blog.entity.Comments;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommmentRepository extends JpaRepository<Comments,Integer> {
    public List<Comments> getByBlog(int id);
}
