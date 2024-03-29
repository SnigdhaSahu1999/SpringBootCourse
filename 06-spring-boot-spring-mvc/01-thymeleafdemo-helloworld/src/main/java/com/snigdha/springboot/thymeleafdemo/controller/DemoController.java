package com.snigdha.springboot.thymeleafdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class DemoController {

    // Create a mapping for "/hello

    @GetMapping("/hello")
    public String sayHello(Model theModel){

        theModel.addAttribute("theDate",new java.util.Date());

        return "helloworld";
        // helloworld.html
        //Since we have thymeleaf dependency in MAVEN POM, SB will autoconfigure to use Thymeleaf


    }
}
