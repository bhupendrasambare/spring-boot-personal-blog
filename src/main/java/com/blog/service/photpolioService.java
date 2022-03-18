package com.blog.service;

import com.blog.entity.Blog;
import com.blog.entity.Photpolio;
import com.blog.repository.PhotpolioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class photpolioService {

    @Autowired
    PhotpolioRepository photpolioRepository;

    public Photpolio save(Photpolio photpolio){
        return photpolioRepository.save(photpolio);
    }

    public List<Photpolio> getPhotPolio(){
        return photpolioRepository.findAll();
    }

    public Photpolio getbyId(int id){
        return photpolioRepository.findById(id).get();
    }

    public void increseVIew(int id){
        Photpolio b = photpolioRepository.findById(id).get();
        b.setViews(b.getViews()+1);
        photpolioRepository.save(b);
    }

    public void deleteById(int id){
        photpolioRepository.deleteById(id);
    }

}
