package net.ua.dao;

import net.ua.entity.User;
import net.ua.exeptions.UserNotFoundException;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface UserDao {

	public List<User> getAllUsers();

	public void addUser(User user);

	public void deleteUser(User user);

	public User getById(int id);

	public void updateUser(User user);

	public User getUser(String username) throws UserNotFoundException;

}
