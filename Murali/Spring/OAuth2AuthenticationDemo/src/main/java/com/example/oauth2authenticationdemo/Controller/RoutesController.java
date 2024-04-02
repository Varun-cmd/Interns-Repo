package com.example.oauth2authenticationdemo.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RoutesController {

    @GetMapping("/home")
    public String home(){
        return "Hello!";
    }

    @GetMapping("/secure")
    public String securePage(){
        return "Secure Page";
    }

}
