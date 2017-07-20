package ua.nure.indplan.service;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Student;

@Service
public interface StudentService {

    List<Student> findAll();
    
    List<Student> findByName(String pattern);

    List<Student> findByName(String pattern, int maxCount);
    
    void add(Student stud);

    Student getById(int id);

	void add(Set<Student> students);
    
}
