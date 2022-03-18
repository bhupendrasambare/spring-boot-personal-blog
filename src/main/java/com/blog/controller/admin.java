package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.entity.Request;
import com.blog.service.blogService;
import com.blog.service.contactService;
import com.blog.service.photpolioService;
import com.blog.service.requestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class admin {

    @Autowired
    blogService blogService;

    @Autowired
    photpolioService photpolioService;

    @Autowired
    contactService contactService;

    @Autowired
    requestService requestService;

    @GetMapping({"","index"})
    public String index(Model m){
        m.addAttribute("header","Photpolio");
        m.addAttribute("Photpolios",photpolioService.getPhotPolio());
        return "admin/index";
    }

    @GetMapping("blog")
    public String blog(Model m){
        m.addAttribute("header","Blogs");
        m.addAttribute("blogs",blogService.getBlogs());
        return "admin/blog";
    }

    @GetMapping("feedback")
    public String feedback(Model m){
        m.addAttribute("feedback",contactService.getAllContact());
        m.addAttribute("header","Feedback");
        return "admin/feedback";
    }

    @GetMapping("request")
    public String user(Model m){
        m.addAttribute("header","Photpolio Requests");
        m.addAttribute("request",requestService.getAll());
        return "admin/user";
    }

//    @GetMapping("")

}
