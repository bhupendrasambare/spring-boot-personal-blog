package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.entity.Photpolio;
import com.blog.service.blogService;
import com.blog.service.photpolioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/")
public class adminform {

    @Autowired
    blogService blogService;

    @Autowired
    photpolioService photpolioService;

    @GetMapping("addblog")
    public String blog(Model m){
        m.addAttribute("header","Blogs");
        Blog b = new Blog(0,"","","",0,"","");
        m.addAttribute("blog",b);
        return "admin/add/addblog";
    }

    @GetMapping("addphotpolio")
    public String photpolio(Model m){
        m.addAttribute("header","Add Blog");
        m.addAttribute("photpolio",new Photpolio(0,"","","","",0));
        return "admin/add/addPhotpolio";
    }

    @GetMapping("blog/edit/{id}")
    public String editBlog(@PathVariable("id") int id,Model m){
        m.addAttribute("header","Blogs");
        m.addAttribute("blog",blogService.getById(id));
        return "admin/add/addblog";
    }

    @GetMapping("index/edit/{id}")
    public String editPhotpolio(@PathVariable("id") int id,Model m){
        m.addAttribute("header","Blogs");
        m.addAttribute("photpolio",photpolioService.getbyId(id));
        return "admin/add/addPhotpolio";
    }

    @GetMapping("blog/delete/{blogid}")
    public String deleteBlog(@PathVariable("blogid") int id){
        blogService.deleteById(id);
        return "redirect:/admin/blog";
    }

    @GetMapping("index/delete/{id}")
    public String deletePhotpolio(@PathVariable("id") int id){
        photpolioService.deleteById(id);
        return "redirect:/admin/";
    }

}
