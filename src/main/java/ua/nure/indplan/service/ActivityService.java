package ua.nure.indplan.service;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Activity;

import java.util.List;

@Service
public interface ActivityService {

    public List<Activity> getAll();

    public void add(Activity activity);

    public Activity getById(int id);

    public void delete(Activity activity);

    public void update(Activity activity);
}
