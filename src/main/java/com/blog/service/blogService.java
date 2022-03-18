package com.blog.service;

import com.blog.entity.Blog;
import com.blog.repository.blogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

@Service
public class blogService {
    @Autowired
    blogRepository blogRepository;

    public Blog createBlog(Blog blog){
        return blogRepository.save(blog);
    }

    public List<Blog> getBlogs(){
        return blogRepository.findAll();
    }

    public Blog getById(int id){
        Blog b=new Blog();
        b=blogRepository.findById(id).get();
        return b;
    }

    public void increseVIew(int id){
        Blog b = blogRepository.findById(id).get();
        b.setViews(b.getViews()+1);
        blogRepository.save(b);
    }

    public List<Blog> getBlogBYLimit(int num){
        List<Blog> b = blogRepository.findAll();
        List<Blog> a = new ArrayList<Blog>();
        if(b.size() < num){
            for(int i=0;i<b.size();i++){
                a.add(b.get(i));
            }
        }else {
            for(int i=0;i<num;i++){
                a.add(b.get(i));
            }
        }
        return a;
    }


    public void deleteById(int id){
        blogRepository.deleteById(id);
    }
}
