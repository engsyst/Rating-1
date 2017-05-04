package ua.nure.indplan.service;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Work;

import java.util.List;

@Service
public interface WorkService {

    List<Work> getAllCategories();

    void addWork(Work category);

    Work getById(int id);

    void deleteWork(Work category);

    void updateWork(Work category);
}
