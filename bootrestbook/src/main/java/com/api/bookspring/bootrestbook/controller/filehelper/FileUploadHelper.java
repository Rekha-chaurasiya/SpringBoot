package com.api.bookspring.bootrestbook.controller.filehelper;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
@Component
public class FileUploadHelper {
  private final String uploadFile="C:\\Users\\RekhaChaurasiya\\OneDrive - UNICOSMOSOFT\\Desktop\\My Personal\\SpringBootRestApi\\bootrestbook\\src\\main\\resources\\static\\image" ; 
    
  public boolean upload(MultipartFile file)

  {
    boolean f=false;
    try{
      Files.copy(file.getInputStream(),Paths.get(uploadFile+File.separator + file.getOriginalFilename()),StandardCopyOption.REPLACE_EXISTING);
      f=true;
    }catch(Exception e){
      e.printStackTrace();
    }
    return  f;
  }
}
