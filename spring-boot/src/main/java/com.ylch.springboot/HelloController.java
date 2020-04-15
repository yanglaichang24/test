package com.ylch.springboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/test")
    @ResponseBody
    public String test(){
        return "hell";
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloController.class,args);
    }



}
