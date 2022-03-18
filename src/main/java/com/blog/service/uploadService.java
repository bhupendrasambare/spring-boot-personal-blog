package com.blog.service;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class uploadService {


    private final String ImageFolder = new ClassPathResource("static/image/").getFile().getAbsolutePath();

    public String getdate(){
        Date date = new Date();
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public uploadService() throws IOException {
    }

    public String saveImage(MultipartFile image, String folder) throws IOException {
        String fileName = StringUtils.cleanPath(image.getOriginalFilename());

        int b = (int)(Math.random()*(9999999-1000000+1)+1000000);
        Files.copy(image.getInputStream(),
                Paths.get(ImageFolder+ File.separator+folder+File.separator+b+image.getOriginalFilename()),
                StandardCopyOption.REPLACE_EXISTING);
        return b+image.getOriginalFilename();
    }
}
