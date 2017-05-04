package ua.nure.indplan.dao.realisation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.WorkTypeDao;
import ua.nure.indplan.entity.WorkType;

public class WorkTypeDaoImpl implements WorkTypeDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<WorkType> getAll() {
        return getSession().getNamedQuery("WorkType.findAll").list();
    }

    @Override
    public void add(WorkType type) {
        getSession().save(type);
    }

    @Override
    public WorkType getById(int id) {
        return (WorkType) getSession().get(WorkType.class, id);
    }

//    @Override
//    public void delete(WorkType type) {
//        getSession().delete(type);
//    }
//
    @Override
    public void update(WorkType type) {
        getSession().update(type);
    }
    
}
