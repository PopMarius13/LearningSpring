package com.learning.spring.learningspring;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {

    //GET
    //URI - /hello-world
    //method - "Hello World"
    @GetMapping(path = "/hello-world")
    public String helloWord(){
        return "Hello World!";
    }

    //URI hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWordBean(){
        return new HelloWorldBean("Hello World!");
    }
}
