package ua.nure.indplan.dao.realisation;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
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
		for (Student student : studs) {
			Hibernate.initialize(student);
		}
		return studs;
	}

	@Override
	public void add(Student student) {
		Session session = getSession();
		session.save(student);
	}

	@Override
	public void add(Set<Student> students) {
		Session session = getSession();
		for (Student stud : students) {
			if (stud.getId() == 0) {
				session.save(stud);
			}
		}
	}
	
	@Override
	public Student getById(int id) {
		Session session = getSession();
		Student st = (Student) session.get(Student.class, id);
		return st;
	}

}
