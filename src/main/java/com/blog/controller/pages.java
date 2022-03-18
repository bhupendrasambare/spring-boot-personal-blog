package com.blog.controller;

import com.blog.entity.Contact;
import com.blog.service.blogService;
import com.blog.service.contactService;
import com.blog.service.photpolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class pages {

    @Autowired
    contactService contactService;

    @Autowired
    photpolioService photpolioService;

    @Autowired
    blogService blogService;

    @GetMapping({"/","/index",""})
    public String index(Model m){
        m.addAttribute("photpolios",photpolioService.getPhotPolio());
        return "photpolio";
    }

    @GetMapping("/about")
    public String about(){
        return "about";
    }

    @GetMapping("/blog")
    public String blog(Model m){
        m.addAttribute("blogs",blogService.getBlogs());
        m.addAttribute("recent",blogService.getBlogBYLimit(5));
        return "blog";
    }

    @GetMapping("/contact")
    public String contact(){
        return "contact";
    }

    @PostMapping("/contact")
    public String contactPost(@RequestParam("name")String name,
                              @RequestParam("email") String email,
                              @RequestParam("message") String message,
                              @RequestParam("date") String date){
        contactService.create(new Contact(null,name,email,message,date));
        return "redirect:/";
    }

}
