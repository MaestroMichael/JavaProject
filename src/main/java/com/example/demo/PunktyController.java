package com.example.demo;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/punkty")
public class PunktyController {
    //private CopyOnWriteArrayList<String> users = new CopyOnWriteArrayList<>(Arrays.asList("Student 1", "Student 2", "Student 3"));
    //private StudentService service = new StudentService(repository);

    private final StudentService service;

    public PunktyController(StudentService service) {
        this.service = service;
    }

//    public PunktyController(StudentService service) {
//        this.service = service;
//    }
////    public PunktyController(StudentRepository service) {
////        this.service = service;
////    }

    //@RequestMapping(value = "/users", method = RequestMethod.GET)
    @RequestMapping(value = "/students", method = RequestMethod.GET, produces= MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers() {
        return this.service.getStudents().asJava();
//        return (List<Student>) this.service.getStudents();
        //return users;
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST,consumes=MediaType.APPLICATION_JSON_UTF8_VALUE)
    //int addUser(@RequestBody String name)
    public Student addUser(@RequestBody NewStudent student) {
        //users.add(name);
        //return users.size();
        return this.service.addStudent(student);
    }

    @RequestMapping(value =  "/students/{id}/numer/{numer}", method = RequestMethod.POST,produces=MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student setNumer(@PathVariable("id") long id, @PathVariable("numer") String numer) {
        return this.service.changeNumber(id, numer).orElseThrow(
                () -> new IllegalArgumentException("Student o id: " + id + " does not exist") );
    }


    @RequestMapping(value = "/students/{id}/score")
    public int addScore(@PathVariable("id") long id,@RequestBody Score score){
        return this.service.addScore(id, score)
                .orElseThrow(
                        ()->new NoStudentException(id));

    }

}
