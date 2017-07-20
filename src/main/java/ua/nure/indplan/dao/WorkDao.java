package ua.nure.indplan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Work;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface WorkDao extends CrudRepository<Work, Integer> {

	List<Work> findAll();

}
