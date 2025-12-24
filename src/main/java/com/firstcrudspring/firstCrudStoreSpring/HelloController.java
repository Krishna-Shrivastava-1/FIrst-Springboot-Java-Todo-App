package com.firstcrudspring.firstCrudStoreSpring;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class HelloController {
    @GetMapping("/hello")
    public String hello() {
        return "🚀 Spring Boot server running! Your first Java backend!";
    }

    @GetMapping("/health")
    public String health(){
        return "It's Hero Time Server";
    }
}
