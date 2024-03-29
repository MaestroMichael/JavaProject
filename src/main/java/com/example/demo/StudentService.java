package com.example.demo;


import com.example.demo.db.ScoreRepository;
import com.example.demo.db.ScoreRow;
import com.example.demo.db.StudentRepository;
import com.example.demo.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class StudentService {
    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;
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
        return List.ofAll(this.studentRepository.findAll()).map(StudentRow::toStudent);
        // throw new UnsupportedOperationException();
    }

//    private Function<StudentRow, Student> getStudentRowStudentFunction() {
//        return dbObj ->
//                new Student(dbObj.getId(), dbObj.getName(), dbObj.getNumer(), dbObj.getGrupa());
//    }


    //    Student addStudent(final NewStudent newStudent) {
////        throw new UnsupportedOperationException();
//        StudentRow created = this.repository.save(new StudentRow(newStudent.name, newStudent.numer, newStudent.grupa));
//        return getStudentRowStudentFunction().apply(created);
//    }
    Student addStudent(final NewStudent newStudent) {
        return this.studentRepository.save(new StudentRow(
                newStudent.name,
                newStudent.numer,
                newStudent.grupa)).toStudent();
    }

    public StudentService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }
    // private List<Student> students = List.empty();

    @Transactional
    public Optional<Student> changeNumber(long studentId, String newNumber) {
        final Optional<StudentRow> student =
                this.studentRepository.findById(studentId);
        return student.map(c -> {
            c.setNumer(newNumber);
            studentRepository.save(c);
            return c.toStudent();
        });
    }

    @Transactional
    public Optional<Integer> addScore(final long studentId, final Score score) {
        final Optional<StudentRow> student =
                this.studentRepository.findById(studentId);
        return student.map(c->{
            int existingScore=List.ofAll(c.getScores())
                    .foldLeft(0,(p,s)-> Math.toIntExact(p + s.getScore()));
            final ScoreRow newScore=new ScoreRow(score.score,score.comment,c);
            this.scoreRepository.save(newScore);
            return existingScore+score.score;});}

}
