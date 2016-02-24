package net.ua.dao;

import net.ua.entity.Category;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface CategoryDao {

    List<Category> getAllCategories();

    void addCategory(Category category);

    Category getById(int id);

    void deleteCategory(Category category);

    void updateCategory(Category category);
}
