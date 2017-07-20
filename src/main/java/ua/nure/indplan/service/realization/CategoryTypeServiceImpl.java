package ua.nure.indplan.service.realization;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.CategoryTypeDao;
import ua.nure.indplan.entity.CategoryType;
import ua.nure.indplan.service.CategoryTypeService;

public class CategoryTypeServiceImpl implements CategoryTypeService {

    @Autowired
    CategoryTypeDao typeDao;

    @Override
    public List<CategoryType> getAll() {
        return typeDao.findAll();
    }

    @Override
    public void add(CategoryType type) {
        typeDao.save(type);
    }

    @Override
    public CategoryType getById(int id) {
        return typeDao.findOne(id);
    }

    @Override
    public void delete(CategoryType type) {
        typeDao.delete(type);
    }

    @Override
    public void update(CategoryType type) {
        typeDao.save(type);
    }
}
