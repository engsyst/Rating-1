package ua.nure.indplan.dao;

import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Activity;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface ActivityDao {

    public List<Activity> getAllActivities();

    public void addActivity(Activity activity);

    public Activity getById(int id);

    public void deleteActivity(Activity activity);

    public void updateActivity(Activity activity);
}
