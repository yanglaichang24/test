package com.ylch.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@EnableAutoConfiguration
@ComponentScan
public class SpringBootStartApp {

    public static void main(String[] args) {
        SpringApplication.run(SpringBootStartApp.class,args);
    }

}
