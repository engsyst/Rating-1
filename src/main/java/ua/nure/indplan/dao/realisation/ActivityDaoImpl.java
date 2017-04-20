package ua.nure.indplan.dao.realisation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.ActivityDao;
import ua.nure.indplan.entity.Activity;

public class ActivityDaoImpl implements ActivityDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Activity> getAllActivities() {
        return getSession().createQuery("from Activity").list();
    }

    @Override
    public void addActivity(Activity activity) {
        getSession().save(activity);
    }

    @Override
    public Activity getById(int id) {
        return (Activity) getSession().get(Activity.class, id);
    }

    @Override
    public void deleteActivity(Activity activity) {
        getSession().delete(activity);
    }

    @Override
    public void updateActivity(Activity activity) {
        getSession().update(activity);
    }
}
