package net.ua.service;

import net.ua.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    public void addStudent(Student student);

    public void deleteStudent(Student student);

    public Student getById(int id);

    public void updateStudent(Student student);
}
