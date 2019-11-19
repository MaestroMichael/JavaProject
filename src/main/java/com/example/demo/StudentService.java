package com.example.demo;


import com.example.demo.db.StudentRepository;
import com.example.demo.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class StudentService {
    private final StudentRepository repository;
    //    List<Student> getStudents()
//    {
////        return List.empty();
//        return this.students;
//    }
    //int id = 0;



//    Student addStudent(NewStudent n_Student) {
//
////        Student created=new Student(1,"Student1", "1-2-3", "IP");
//
//            id++;
//          int  id1= students.size() +1;
//        Student created=new Student(id1,n_Student.name, n_Student.numer,n_Student.grupa);
//        //return new Student(1,"aa","aa","aa");
//        students=students.prepend(created);
//        return created;
//
//    }

    List<Student> getStudents() {
        return List.ofAll(this.repository.findAll()).map(getStudentRowStudentFunction());
        // throw new UnsupportedOperationException();
    }

    private Function<StudentRow, Student> getStudentRowStudentFunction() {
        return dbObj ->
                new Student(dbObj.getId(), dbObj.getName(), dbObj.getNumer(), dbObj.getGrupa());
    }


    Student addStudent(final NewStudent newStudent) {
//        throw new UnsupportedOperationException();
        StudentRow created = this.repository.save(new StudentRow(newStudent.name, newStudent.numer, newStudent.grupa));
        return getStudentRowStudentFunction().apply(created);
    }
    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }
    // private List<Student> students = List.empty();


}
