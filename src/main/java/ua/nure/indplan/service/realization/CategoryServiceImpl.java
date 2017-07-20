package ua.nure.indplan.service.realization;

import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.CategoryDao;
import ua.nure.indplan.entity.Category;
import ua.nure.indplan.service.CategoryService;

import java.util.List;

public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDao categoryDao;

    @Override
    public List<Category> getAll() {
        return categoryDao.findAll();
    }

    @Override
    public void add(Category category) {
        categoryDao.save(category);
    }

    @Override
    public Category getById(int id) {
        return categoryDao.findOne(id);
    }

    @Override
    public void delete(Category category) {
        categoryDao.delete(category);
    }

    @Override
    public void update(Category category) {
        categoryDao.save(category);
    }
}
