package net.ua.service;

import net.ua.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    public List<User> getAllUsers();

    public void addUser(User user);

    public void deleteUser(User user);

    public User getById(int id);

    public void updateUser(User user);
}
