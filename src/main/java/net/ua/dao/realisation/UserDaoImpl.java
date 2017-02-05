package net.ua.dao.realisation;

import net.ua.dao.UserDao;
import net.ua.entity.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserDaoImpl extends AbstractSessionDAO implements UserDao{

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
        User user2update = getById(user.getUserId());
        user2update.setCreateTime(user.getCreateTime());
        user2update.setEmployee(user.getEmployee());
        user2update.setRole(user.getRole());
        user2update.setEmail(user.getEmail());
        user2update.setPassword(user.getPassword());
        getSession().update(user2update);
    }

    @Override
    public User getUserByEmail(String email) {
        Query query = getSession().createQuery("from User where email = :email");
        query.setString("email", email);
        return (User) query.uniqueResult();
    }

    @Override
    public User getUserByLogin(String login) {
        Query query = getSession().createQuery("from User where login = :login");
        query.setString("login", login);
        return (User) query.uniqueResult();
    }
}
