package com.file.control;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
//@Controller 
public class FileUploadController {

    private static final String UPLOAD_DIR = "D:/uploads/";

    @PostMapping("/upload")
    //@GetMapping("/upload")
    public ResponseEntity<?> uploadFile(@RequestParam("file") MultipartFile file) {
    //public String uploadFile(@RequestParam("file") MultipartFile file) {	
        System.out.println("执行到这里了");
    	if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("请选择一个文件上传");
        }

        try {
            byte[] bytes = file.getBytes();
            Path path = Paths.get(UPLOAD_DIR + file.getOriginalFilename());
            Files.write(path, bytes);
            return ResponseEntity.ok("success upload!--" + file.getOriginalFilename());
        } catch (IOException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("failed upload!--" + e.getMessage());
        }
    }
//    @GetMapping("/upload")
//    public String uploadFile() {
//    	System.out.println("执行到这里了");
//    	return("success");
//    }
}

