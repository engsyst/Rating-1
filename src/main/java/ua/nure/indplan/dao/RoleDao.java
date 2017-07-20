package ua.nure.indplan.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Role;

@Repository
@Transactional
public interface RoleDao extends CrudRepository<Role, Integer> {

	List<Role> findAll();
	
	Role findByRolename(String rolename);
}
