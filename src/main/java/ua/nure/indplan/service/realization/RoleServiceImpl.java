package ua.nure.indplan.service.realization;

import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.RoleDao;
import ua.nure.indplan.entity.Role;
import ua.nure.indplan.exeptions.RoleNotFoundException;
import ua.nure.indplan.service.RoleService;

import java.util.List;

public class RoleServiceImpl implements RoleService {

	@Autowired
	RoleDao roleDao;

	@Override
	public List<Role> getAllRoles() {
		return roleDao.getAllRoles();
	}

	@Override
	public Role getById(int id) {
		return roleDao.getById(id);
	}

	@Override
	public Role getRole(String rolename) throws RoleNotFoundException {
		return roleDao.getRole(rolename);
	}
}
