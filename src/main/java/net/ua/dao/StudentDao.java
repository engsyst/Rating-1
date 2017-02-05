package net.ua.dao;

import net.ua.entity.Group;
import net.ua.entity.Student;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface StudentDao {

    public List<Student> getAllStudents();

    public void addStudent(Student student);

    public void deleteStudent(Student student);

    public Student getById(int id);

    public void updateStudent(Student student);

    public void addStudentGroup(Student student, Group group);
}
