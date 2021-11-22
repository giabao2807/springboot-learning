package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

    @GetMapping(value={"/","/home"})
    public String homepage(){
        return "home"; //trả về home.html
    }

    @GetMapping("/hello")
    public String hello(){
        return "hello"; //trả về hello.html
    }
}
