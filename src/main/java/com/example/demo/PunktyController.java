package com.example.demo;

import com.example.demo.db.StudentRepository;
import org.springframework.http.MediaType;
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
    //private CopyOnWriteArrayList<String> users = new CopyOnWriteArrayList<>(Arrays.asList("Student 1", "Student 2", "Student 3"));
    //private StudentService service = new StudentService(repository);

    private final StudentRepository service;
    public PunktyController(StudentRepository service) {
        this.service = service;
    }

    //@RequestMapping(value = "/users", method = RequestMethod.GET)
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers() {
//        return this.service.getStudents().asJava();
        return this.service.getStudents();
        //return users;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    //int addUser(@RequestBody String name)
    public Student addUser(@RequestBody NewStudent student) {
        //users.add(name);
        //return users.size();
        return this.service.addStudent(student);
    }
}
