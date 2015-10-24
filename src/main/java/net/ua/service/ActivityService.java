package net.ua.service;

import net.ua.entity.Activity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActivityService {

    public List<Activity> getAllActivities();

    public void addActivity(Activity activity);

    public Activity getById(int id);

    public void deleteActivity(Activity activity);

    public void updateActivity(Activity activity);
}
