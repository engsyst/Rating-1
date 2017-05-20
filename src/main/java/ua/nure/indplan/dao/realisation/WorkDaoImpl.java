package ua.nure.indplan.dao.realisation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.WorkDao;
import ua.nure.indplan.entity.Work;

public class WorkDaoImpl implements WorkDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Work> getAll() {
        return getSession().createQuery("from Work").list();
    }

    @Override
    public void addWork(Work work) {
    	Session session = getSession();
        session.save(work);
        System.err.println(session);
    }

    @Override
    public Work getById(int id) {
        return (Work) getSession().get(Work.class, id);
    }

    @Override
    public void deleteWork(Work work) {
        getSession().delete(work);
    }

    @Override
    public void updateWork(Work work) {
    	Session session = getSession();
    	session.update(work);
    }
}
