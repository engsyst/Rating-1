package ua.nure.indplan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.User;

@Repository
@Transactional
public interface UserDao extends CrudRepository<User, Integer> {

	public List<User> findAll();

	public User findByUsernameIgnoreCase(String username);

}
