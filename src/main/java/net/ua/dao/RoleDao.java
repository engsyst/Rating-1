package net.ua.dao;

import net.ua.entity.Role;
import net.ua.exeptions.RoleNotFoundException;

import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoleDao {

	public List<Role> getAllRoles();

	public Role getById(int id);

	public Role getRole(String roleName) throws RoleNotFoundException;
}
