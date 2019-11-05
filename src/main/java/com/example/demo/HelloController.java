package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class HelloController {
    @RequestMapping("/hello")
            String hello() {
        return "Hello! " + LocalTime.now();
    }


}
