package ua.nure.indplan.dao.realisation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.CategoryDao;
import ua.nure.indplan.entity.Category;

public class CategoryDaoImpl implements CategoryDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Category> getAll() {
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
