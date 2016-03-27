package net.ua.dao.realisation;

import net.ua.dao.CategoryDao;
import net.ua.entity.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<Category> getAllCategories() {
        return getSession().createQuery("from Category").list();
    }

    @Override
    public void addCategory(Category category) {
        getSession().save(category);
    }

    @Override
    public Category getById(int id) {
        return (Category) getSession().get(Category.class, id);
    }

    @Override
    public void deleteCategory(Category category) {
        getSession().delete(category);
    }

    @Override
    public void updateCategory(Category category) {
        getSession().update(category);
    }
}
