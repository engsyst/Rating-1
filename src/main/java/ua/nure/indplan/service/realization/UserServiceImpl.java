package ua.nure.indplan.service.realization;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ua.nure.indplan.dao.UserDao;
import ua.nure.indplan.entity.User;
import ua.nure.indplan.exeptions.UserNotFoundException;
import ua.nure.indplan.service.UserService;

public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao;

    @Override
    public List<User> getAllUsers() {
        return userDao.getAllUsers();
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }

    @Override
    public void deleteUser(User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User getById(int id) {
        return userDao.getById(id);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }
    
    @Override
    public User getUser(String username) throws UserNotFoundException {
        return userDao.getUser(username);
    }

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		 try {
	            return getUser(username);
	        } catch (UserNotFoundException e) {
	            throw new UsernameNotFoundException(e.getMessage());
	        }
	}

}
