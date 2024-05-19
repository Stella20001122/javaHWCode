package com.exception.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/endpoint")
    public String endPoint() throws Exception {
//    	System.out.println("成功访问");
//    	return "成功访问";
        throw new Exception("异常出错！");
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleMyException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}