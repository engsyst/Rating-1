package ua.nure.indplan.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Category;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {

    List<Category> findAll();

}
