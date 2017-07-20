package ua.nure.indplan.service.realization;

import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.ActivityDao;
import ua.nure.indplan.entity.Activity;
import ua.nure.indplan.service.ActivityService;

import java.util.List;

public class ActivityServiceImpl implements ActivityService{

    @Autowired
    ActivityDao activityDao;

    @Override
    public List<Activity> getAll() {
        return activityDao.findAll();
    }

    @Override
    public void add(Activity activity) {
        activityDao.save(activity);
    }

    @Override
    public Activity getById(int id) {
        return activityDao.findOne(id);
    }

    @Override
    public void delete(Activity activity) {
        activityDao.delete(activity);
    }

    @Override
    public void update(Activity activity) {
        activityDao.save(activity);
    }
}
