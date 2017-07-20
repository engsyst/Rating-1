package ua.nure.indplan.service;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.User;

@Service
public interface UserService extends UserDetailsService {

    public List<User> getAll();

    public void add(User user);

    public void delete(User user);

    public User getById(int id);

    public void update(User user);
}
