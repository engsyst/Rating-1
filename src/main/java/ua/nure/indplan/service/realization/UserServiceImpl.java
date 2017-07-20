package ua.nure.indplan.service.realization;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ua.nure.indplan.dao.UserDao;
import ua.nure.indplan.entity.User;
import ua.nure.indplan.service.UserService;
import ua.nure.indplan.validation.UserValidator;

public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;
    
    @Autowired
    UserValidator validator;

    @Override
    public List<User> getAll() {
        return userDao.findAll();
    }

    @Override
    public void add(User user) {
        userDao.save(user);
    }

    @Override
    public void delete(User user) {
        userDao.delete(user);
    }

    @Override
    public User getById(int id) {
        return userDao.findOne(id);
    }

    @Override
    public void update(User user) {
        userDao.save(user);
    }
    

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userDao.findByUsernameIgnoreCase(username);
		if (user == null) {
			throw new UsernameNotFoundException("User not found");
		}
		return user;
	}

}
