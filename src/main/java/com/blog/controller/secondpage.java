package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.entity.Comments;
import com.blog.entity.Photpolio;
import com.blog.entity.Request;
import com.blog.repository.requestRepository;
import com.blog.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Controller
public class secondpage {

    @Autowired
    blogService blogService;

    @Autowired
    photpolioService photpolioService;

    @Autowired
    commentsService commentsService;

    @Autowired
    requestService requestService;

    @Autowired
    uploadService uploadService;

    @GetMapping("/blog/{id}")
    public String getBlog(@PathVariable("id")int id, Model model){
        model.addAttribute("blog",blogService.getById(id));
        model.addAttribute("recent",blogService.getBlogBYLimit(5));
        model.addAttribute("comments",commentsService.getCommentByBogId(id));
        blogService.increseVIew(id);
        return "blog-single";
    }

    @GetMapping("/index/{id}")
    public String getPhotpolio(@PathVariable("id")int id,Model model){
        Photpolio p = photpolioService.getbyId(id);
        model.addAttribute("tags",getTags(p.getTags()));
        model.addAttribute("photpolio",p);
        photpolioService.increseVIew(id);
        return "portfolio-item";
    }

    @PostMapping("/blog/{id}")
    public String setComment(@PathVariable("id")int id,
                             @RequestParam("name")String name,
                             @RequestParam("email")String email,
                             @RequestParam("comment")String comment){
        commentsService.create(new Comments(null,name,comment,id,email));
        return "redirect:/blog/"+id;
    }
    @PostMapping("/index/{id}")
    public String setRequest(@PathVariable("id")int id,
                             @RequestParam("name")String name,
                             @RequestParam("email")String email,
                             @RequestParam("comment")String comment){
        requestService.create(new Request(null,name,email,comment,id,uploadService.getdate()));
        return "redirect:/index/"+id;
    }
    private List<String> getTags(String s){
        List<String> tags = Arrays.asList(s.split("#"));
        return tags;
    }
}
