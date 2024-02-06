package com.api.bookspring.bootrestbook.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.api.bookspring.bootrestbook.controller.filehelper.FileUploadHelper;

@RestController
public class FileUploadController {

    @Autowired
    FileUploadHelper fileuploadhelper;   
    @PostMapping("/fileupload")
    public ResponseEntity<String> fileUpload(@RequestParam("file") MultipartFile file)
    {
    
    //  System.out.println(file.getContentType());
    //  System.out.println(file.getSize());
    //  System.out.println(file.getName());
    //  System.out.println(file.getOriginalFilename());

    if(file.isEmpty())
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("file is empty");
    }
    if(!file.getContentType().equals("image/jpeg"))
    {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Mismatch");
    }
    boolean  flag =fileuploadhelper.upload(file);
    
        if(flag)
        {
            return ResponseEntity.ok("file successfully added");
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).body("something went wrong!");
        }
    

     
    }
    
}
