package com.example.demo;

import com.example.demo.db.StudentRepository;
import io.vavr.collection.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;

    @Test
    //test1
    public void getEmptyList() {
        final StudentService service = new StudentService(repository);
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    //test2
    public void addStudent() {
        final StudentService service = new StudentService(repository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        assertNotNull(created);

    }

@Test
    public void addStudentIsReturned(){
    final StudentService service = new StudentService(repository);
    final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
    final List<Student> all = service.getStudents();
    assertEquals("Student1",all.head().name);
}

@Test
    public void addStudnetsHasNewId(){
        final StudentService service=new StudentService(repository);
        final Student s1=service.addStudent(new NewStudent("S1","123","ip30"));
        final Student s2=service.addStudent(new NewStudent("s2","234","ip30"));
        assertNotEquals(s1.id,s2.id);
        assertEquals(2,service.getStudents().size());
}
}