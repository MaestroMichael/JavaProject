package com.example.demo;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@RestController
public class HelloController {
    @RequestMapping(value = "/hello", method = RequestMethod.GET)

    String hello() {
        return "Hello! " + LocalTime.now();
    }


}
