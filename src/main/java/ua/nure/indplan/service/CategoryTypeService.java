package ua.nure.indplan.service;

import java.util.List;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.CategoryType;

@Service
public interface CategoryTypeService {

    List<CategoryType> getAll();

    void add(CategoryType type);

    CategoryType getById(int id);

    void delete(CategoryType type);

    void update(CategoryType type);
}
