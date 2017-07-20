package ua.nure.indplan.service;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Role;
import ua.nure.indplan.exeptions.RoleNotFoundException;

import java.util.List;

@Service
public interface RoleService {

	public List<Role> getAll();

	public Role getById(int id);

	public Role getRole(String rolename) throws RoleNotFoundException;
}
