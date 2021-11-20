package com.learning.spring.learningspring.hello.world;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

// Controller
@RestController
public class HelloWorldController {
    @Autowired
    private MessageSource messageSource;

    //GET
    //URI - /hello-world
    //method - "Hello World"
    @GetMapping(path = "/hello-world")
    public String helloWord() {
        return "Hello World!";
    }

    //URI /hello-world-bean
    @GetMapping(path = "/hello-world-bean")
    public HelloWorldBean helloWordBean() {
        return new HelloWorldBean("Hello World!");
    }

    ///URI /hello-world/path-variable/Marius
    @GetMapping(path = "/hello_world/path-variable/{name}")
    public HelloWorldBean helloWorldPathVariable(@PathVariable String name) {
        return new HelloWorldBean("Hello World, " + name + "!");
    }

    @GetMapping(path = "/hello-world-internationalized")
    public String helloWordInternationalized() {

        return messageSource.getMessage("good.morning.message",
                null, "Default Message", LocaleContextHolder.getLocale());
    }

}
