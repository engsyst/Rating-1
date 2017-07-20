package ua.nure.indplan.service;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Work;

import java.util.List;

@Service
public interface WorkService {

    List<Work> getAll();

    void add(Work category);

    Work getById(int id);

    void delete(Work category);

    void update(Work category);
}
