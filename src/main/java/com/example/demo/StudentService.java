package com.example.demo;


import com.example.demo.db.StudentRepository;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final StudentRepository repository;
    //    List<Student> getStudents()
//    {
////        return List.empty();
//        return this.students;
//    }
    int id = 0;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

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
        return List.ofAll(this.repository.findAll()).map(dbObj -> new Student(dbObj.getId(), dbObj.getName(), dbObj.getNumer(), dbObj.getGrupa()));
        // throw new UnsupportedOperationException();
    }

    Student addStudent(final NewStudent newStudent) {
        throw new UnsupportedOperationException();
    }

    private List<Student> students = List.empty();


}
