package net.ua.service;

import net.ua.entity.Category;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getAllCategories();

    void addCategory(Category category);

    Category getById(int id);

    void deleteCategory(Category category);

    void updateCategory(Category category);
}
