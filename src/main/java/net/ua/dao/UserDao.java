package net.ua.dao;

import net.ua.entity.User;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface UserDao {

    List<User> getAllUsers();

    void addUser(User user);

    void deleteUser(User user);

    User getById(int id);

    void updateUser(User user);

    User getUserByEmail(String email);

    User getUserByLogin(String login);

}
