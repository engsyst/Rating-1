package net.ua.dao.realisation;

import net.ua.dao.UserDao;
import net.ua.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class UserDaoImpl implements UserDao{

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public List<User> getAllUsers() {
        return getSession().createQuery("from User").list();
    }

    @Override
    public void addUser(User user) {
        getSession().save(user);
    }

    @Override
    public void deleteUser(User user) {
        getSession().delete(user);
    }

    @Override
    public User getById(int id) {
        return (User) getSession().get(User.class, id);
    }

    @Override
    public void updateUser(User user) {
        getSession().update(user);
    }
}
