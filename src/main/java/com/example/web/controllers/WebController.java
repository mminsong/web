package com.example.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/web") //localhost:8000/web
    public String webForm(){return "/web/web";}
    @GetMapping("/calendar.html")
    public String hello() {
        return "/web/calendar";
    }
}
