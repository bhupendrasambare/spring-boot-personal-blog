package com.blog.service;

import com.blog.entity.Request;
import com.blog.repository.requestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class requestService {
    @Autowired
    requestRepository requestRepository;

    public Request create(Request request){
        return requestRepository.save(request);
    }

    public List<Request> getAll(){
        return requestRepository.findAll();
    }
}
