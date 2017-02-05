package net.ua.dao;

import net.ua.entity.Activity;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface ActivityDao {

    public List<Activity> getAllActivities();

    public void addActivity(Activity activity);

    public Activity getById(int id);

    public void deleteActivity(Activity activity);

    public void updateActivity(Activity activity);
}
