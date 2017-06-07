package ua.nure.indplan.dao.realisation;

import java.util.List;
import java.util.Set;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.WorkDao;
import ua.nure.indplan.entity.Student;
import ua.nure.indplan.entity.Work;
import ua.nure.indplan.service.StudentService;

public class WorkDaoImpl implements WorkDao {

    @Autowired
    SessionFactory sessionFactory;

    @Autowired
    StudentService studentService;
    
    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Work> getAllCategories() {
        return getSession().createQuery("from Work").list();
    }

    @Override
    public void addWork(Work work) {
    	Session session = getSession();
    	studentService.add(work.getStudents());
        session.save(work);
    }

    @Override
    public Work getById(int id) {
    	Session session = getSession();
    	Work work = (Work) session.get(Work.class, id);
    	Hibernate.initialize(work);
        return work;
    }

    @Override
    public void deleteWork(Work work) {
        getSession().delete(work);
    }

    @Override
    public void updateWork(Work work) {
    	Session session = getSession();
    	studentService.add(work.getStudents());
    	session.merge(work);
    }
}
