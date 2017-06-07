package ua.nure.indplan.dao;

import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Student;

@Repository
@Transactional
public interface StudentDao {

	List<Student> getAll();

	List<Student> findByName(String pattern, int maxCount);

	void add(Student student);

	Student getById(int id);

	void add(Set<Student> students);

}
