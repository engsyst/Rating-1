package net.ua.dao.realisation;

import net.ua.dao.ActivityDao;
import net.ua.entity.Activity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Repository
public class ActivityDaoImpl extends AbstractSessionDAO implements ActivityDao {

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
