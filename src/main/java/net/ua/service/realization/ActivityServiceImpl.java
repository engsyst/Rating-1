package net.ua.service.realization;

import net.ua.dao.ActivityDao;
import net.ua.entity.Activity;
import net.ua.service.ActivityService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class ActivityServiceImpl implements ActivityService{

    @Autowired
    ActivityDao activityDao;

    @Override
    public List<Activity> getAllActivities() {
        return activityDao.getAllActivities();
    }

    @Override
    public void addActivity(Activity activity) {
        activityDao.addActivity(activity);
    }

    @Override
    public Activity getById(int id) {
        return activityDao.getById(id);
    }

    @Override
    public void deleteActivity(Activity activity) {
        activityDao.deleteActivity(activity);
    }

    @Override
    public void updateActivity(Activity activity) {
        activityDao.updateActivity(activity);
    }
}
