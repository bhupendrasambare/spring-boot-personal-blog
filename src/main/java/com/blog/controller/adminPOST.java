package com.blog.controller;

import com.blog.entity.Blog;
import com.blog.entity.Photpolio;
import com.blog.service.blogService;
import com.blog.service.photpolioService;
import com.blog.service.uploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
@RequestMapping("/admin/")
public class adminPOST {

    @Autowired
    blogService blogService;

    @Autowired
    uploadService uploadService;

    @Autowired
    photpolioService photpolioService;

    @PostMapping("addblog")
    public String addBlog(@RequestParam("id") int id,
                          @RequestParam("name")String name,
                          @RequestParam("about")String about,
                          @RequestParam("tags")String tags,
                          @RequestParam("filename")String filename,
                          @RequestParam("image") MultipartFile image) throws IOException {
        String file=null;
        if (image.getOriginalFilename().contains(".")){
            file = uploadService.saveImage(image,"photpolio");
        }else{
            file = filename;
        }
        Blog b = new Blog(null,name,file,uploadService.getdate(),0,about,tags);
        if (id !=0){
            b.setId(id);
        }
        blogService.createBlog(b);
        return "redirect:/admin/blog";
    }

    @PostMapping("addphotpolio")
    public String addphotpolio(@RequestParam("id") int id,
                          @RequestParam("name")String name,
                          @RequestParam("details")String about,
                          @RequestParam("tags")String tags,
                          @RequestParam("filename")String filename,
                          @RequestParam("image") MultipartFile image) throws IOException {
        String file=null;
        if (image.getOriginalFilename().contains(".")){
            file = uploadService.saveImage(image,"photpolio");
        }else{
            file = filename;
        }
        Photpolio p = new Photpolio(null,name,tags,about,file,0);
        if (id !=0){
            p.setId(id);
        }
        photpolioService.save(p);
        return "redirect:/admin/index";
    }
}
