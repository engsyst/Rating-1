package ua.nure.indplan.dao.realisation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.StudentDao;
import ua.nure.indplan.entity.Student;

public class StudentDaoImpl implements StudentDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<Student> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Student> findByName(String pattern, int maxCount) {
		Session session = getSession();
		List<Student> studs = session.createCriteria(Student.class)
			.add(Restrictions.like("name", pattern + "%").ignoreCase())
			.setMaxResults(maxCount).list();
		return studs;
	}

	@Override
	public void addStudent(Student student) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Student getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
