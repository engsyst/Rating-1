package ua.nure.indplan.service.realization;


import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.StudentDao;
import ua.nure.indplan.entity.Student;
import ua.nure.indplan.service.StudentService;


public class StudentServiceImpl implements StudentService {

	public static final int DEFAULT_MAX_COUNT = 10;
	
    @Autowired
    StudentDao studentDao;

    @Override
    public List<Student> getAll() {
        return studentDao.getAll();
    }

    @Override
    public void add(Student student) {
        studentDao.add(student);
    }

    @Override
    public void add(Set<Student> students) {
    	if (students != null && students.size() != 0) {
    		studentDao.add(students);
    	}
    }
    
    @Override
    public Student getById(int id) {
        return studentDao.getById(id);
    }
    
    @Override
    public List<Student> findByName(String pattern) {
    	return studentDao.findByName(pattern, DEFAULT_MAX_COUNT);
    }

	@Override
	public List<Student> findByName(String pattern, int maxCount) {
		return studentDao.findByName(pattern, maxCount);
	}
}
