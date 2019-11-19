package com.example.demo.db;

import com.example.demo.NewStudent;
import com.example.demo.Student;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepository extends CrudRepository<StudentRow,Long> {
    List<Student> getStudents();

    Student addStudent(NewStudent student);
}
