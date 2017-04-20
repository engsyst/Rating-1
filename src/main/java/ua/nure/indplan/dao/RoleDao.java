package ua.nure.indplan.dao;

import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Role;
import ua.nure.indplan.exeptions.RoleNotFoundException;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface RoleDao {

	public List<Role> getAllRoles();

	public Role getById(int id);

	public Role getRole(String roleName) throws RoleNotFoundException;
}
