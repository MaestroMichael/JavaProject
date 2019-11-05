package com.example.demo;


import io.vavr.collection.List;

public class StudentService {

    List<Student> getStudents()
    {
//        return List.empty();
        return this.students;
    }
    int id=0;
    Student addStudent(NewStudent n_Student) {

//        Student created=new Student(1,"Student1", "1-2-3", "IP");

            id++;
          int  id1= students.size() +1;
        Student created=new Student(id1,n_Student.name, n_Student.numer,n_Student.grupa);
        //return new Student(1,"aa","aa","aa");
        students=students.prepend(created);
        return created;

    }

    private List<Student> students = List.empty();


}
