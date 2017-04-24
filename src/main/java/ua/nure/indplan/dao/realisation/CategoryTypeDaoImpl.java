package ua.nure.indplan.dao.realisation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.CategoryTypeDao;
import ua.nure.indplan.entity.CategoryType;

public class CategoryTypeDaoImpl implements CategoryTypeDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<CategoryType> getAll() {
        return getSession().getNamedQuery("CategoryType.findAll").list();
    }

    @Override
    public void add(CategoryType type) {
        getSession().save(type);
    }

    @Override
    public CategoryType getById(int id) {
        return (CategoryType) getSession().get(CategoryType.class, id);
    }

    @Override
    public void delete(CategoryType type) {
        getSession().delete(type);
    }

    @Override
    public void update(CategoryType type) {
        getSession().update(type);
    }
    
    @Override
    public void deleteCategoryType(int id) {
    	Session session = getSession();
    	CategoryType type = (CategoryType) session.get(CategoryType.class, id);
    	type.setDeleted(true);
    	session.update(type);
    }
    
}
