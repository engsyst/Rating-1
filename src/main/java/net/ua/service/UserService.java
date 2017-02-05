package net.ua.service;

import net.ua.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    User getById(int id);

    void updateUser(User user);

    User getUserByEmail(String email);

    User getUserByLogin(String login);
}
