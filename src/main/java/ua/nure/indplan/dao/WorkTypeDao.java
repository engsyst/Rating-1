package ua.nure.indplan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.WorkType;

@Repository
@Transactional
public interface WorkTypeDao {

    List<WorkType> getAll();

    void add(WorkType category);

    WorkType getById(int id);

//    void delete(WorkType category);

    void update(WorkType category);

}
