package ua.nure.indplan.service;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Category;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getAll();

    void addCategory(Category category);

    Category getById(int id);

    void deleteCategory(Category category);

    void updateCategory(Category category);
}
