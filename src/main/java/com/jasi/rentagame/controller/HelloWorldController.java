package com.jasi.rentagame.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
@RequestMapping("/hello-world")
public class HelloWorldController {
    @GetMapping("/hello-world")
    public String getMethodName() {
        return new String("Hello World");
    }    
}
