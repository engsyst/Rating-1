package ua.nure.indplan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.CategoryType;

@Repository
@Transactional
public interface CategoryTypeDao {

    List<CategoryType> getAll();

    void add(CategoryType category);

    CategoryType getById(int id);

    void delete(CategoryType category);

    void update(CategoryType category);

	void deleteCategoryType(int id);
}
