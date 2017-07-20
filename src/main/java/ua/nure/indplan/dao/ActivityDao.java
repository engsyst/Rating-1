package ua.nure.indplan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Activity;

@Repository
@Transactional
public interface ActivityDao extends CrudRepository<Activity, Integer> {
	List<Activity> findAll();
}
