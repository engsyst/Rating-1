package ua.nure.indplan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.CategoryType;

@Repository
@Transactional
public interface CategoryTypeDao extends CrudRepository<CategoryType, Integer> {

    List<CategoryType> findAll();

}
