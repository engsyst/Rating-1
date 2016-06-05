package net.ua.service;

import net.ua.entity.User;
import net.ua.exeptions.UserNotFoundException;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService extends UserDetailsService {

    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUser(User user);

    public User getById(int id);

    public void updateUser(User user);

	User getUser(String username) throws UserNotFoundException;
}
