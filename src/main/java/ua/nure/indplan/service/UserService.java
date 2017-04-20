package ua.nure.indplan.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.User;
import ua.nure.indplan.exeptions.UserNotFoundException;

@Service
public interface UserService extends UserDetailsService {

    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUser(User user);

    public User getById(int id);

    public void updateUser(User user);

    public User getUser(String username) throws UserNotFoundException;
}
