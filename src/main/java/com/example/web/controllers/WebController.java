package com.example.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @GetMapping("/web") //localhost:8000/web
    public String webForm(){return "web";}
    @GetMapping("/calendar.html")
    public String hello() {
        return "calendar";
    }
}
