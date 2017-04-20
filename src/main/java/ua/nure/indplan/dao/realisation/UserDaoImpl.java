package ua.nure.indplan.dao.realisation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.UserDao;
import ua.nure.indplan.entity.User;
import ua.nure.indplan.exeptions.UserNotFoundException;

public class UserDaoImpl implements UserDao {

	@Autowired
	SessionFactory sessionFactory;

	private Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
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

	@Override
	public User getUser(String username) throws UserNotFoundException {
		Query query = getSession().createQuery("from User where Login = :login ");
		query.setString("login", username);

		if (query.list().size() == 0) {
			throw new UserNotFoundException("User [" + username + "] not found");
		} else {
			@SuppressWarnings("unchecked")
			List<User> list = (List<User>) query.list();
			User userObject = (User) list.get(0);
			System.err.println("UserDao: 60 - " + userObject);
			return userObject;
		}
	}
}
