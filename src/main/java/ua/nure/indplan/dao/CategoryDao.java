package ua.nure.indplan.dao;

import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Category;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryDao {

    List<Category> getAll();

    void addCategory(Category category);

    Category getById(int id);

    void deleteCategory(Category category);

    void updateCategory(Category category);
}
