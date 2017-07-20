package ua.nure.indplan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.WorkType;

@Repository
@Transactional
public interface WorkTypeDao extends CrudRepository<WorkType, Integer> {

    List<WorkType> findAll();
}
