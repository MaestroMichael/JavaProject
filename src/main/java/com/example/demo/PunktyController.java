package com.example.demo;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/punkty")
public class PunktyController {

    private CopyOnWriteArrayList<String> users = new CopyOnWriteArrayList<>(Arrays.asList("Student 1", "Student 2", "Student 3"));

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    List<String> getUsers(){
        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    int addUser(@RequestBody String name){
        users.add(name);
        return users.size();
    }
}
