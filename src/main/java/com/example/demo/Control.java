package com.example.demo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController


public class Control {
    @GetMapping("/test")
    public String welcome() {
        return "'World' Let's do it";
    }
}
