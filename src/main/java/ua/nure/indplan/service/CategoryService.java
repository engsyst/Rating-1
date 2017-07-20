package ua.nure.indplan.service;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Category;

import java.util.List;

@Service
public interface CategoryService {

    List<Category> getAll();

    void add(Category category);

    Category getById(int id);

    void delete(Category category);

    void update(Category category);
}
