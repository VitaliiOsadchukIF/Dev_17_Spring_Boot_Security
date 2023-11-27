package com.example.Spring_Boot_MVC.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/note")
public class TestController {
    @GetMapping("/test")
    public String testNote() {
        return "test";
    }
}
