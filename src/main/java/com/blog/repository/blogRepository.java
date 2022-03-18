package com.blog.repository;

import com.blog.entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface blogRepository extends JpaRepository<Blog,Integer> {
}
