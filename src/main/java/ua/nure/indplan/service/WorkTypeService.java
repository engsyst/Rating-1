package ua.nure.indplan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.WorkType;

@Service
public interface WorkTypeService {

    List<WorkType> getAll();

    void add(WorkType type);

    WorkType getById(int id);

//    void delete(WorkType type);

    void update(WorkType type);
}
