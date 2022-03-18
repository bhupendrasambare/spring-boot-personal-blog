package com.blog.service;

import com.blog.entity.Comments;
import com.blog.repository.CommmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class commentsService {
    @Autowired
    CommmentRepository commmentRepository;

    public List<Comments> getCommentByBogId(int id){
        return commmentRepository.getByBlog(id);
    }

    public Comments create(Comments comment){
        return commmentRepository.save(comment);
    }
}
