package ua.nure.indplan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Student;

@Repository
@Transactional
public interface StudentDao extends CrudRepository<Student, Integer> {

	List<Student> findAll();

	List<Student> findByNameIgnoreCase(String pattern, int maxCount);

}
