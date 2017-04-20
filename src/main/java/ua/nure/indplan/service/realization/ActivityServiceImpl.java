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
