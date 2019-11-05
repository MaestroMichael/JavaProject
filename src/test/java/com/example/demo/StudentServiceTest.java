package com.example.demo;

import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentServiceTest {

    @Test
    //test1
    public void getEmptyList() {
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    //test2
    public void addStudent() {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        assertNotNull(created);

    }

@Test
    public void addStudentIsReturned(){
    final StudentService service = new StudentService();
    final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
    final List<Student> all = service.getStudents();
    assertEquals("Student1",all.head().name);
}

@Test
    public void addStudnetsHasNewId(){
        final StudentService service=new StudentService();
        final Student s1=service.addStudent(new NewStudent("S1","123","ip30"));
        final Student s2=service.addStudent(new NewStudent("s2","234","ip30"));
        assertNotEquals(s1.id,s2.id);
        assertEquals(2,service.getStudents().size());
}
}