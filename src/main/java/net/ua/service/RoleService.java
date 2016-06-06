package net.ua.service;

import net.ua.entity.Role;
import net.ua.exeptions.RoleNotFoundException;

import org.springframework.stereotype.Service;
import java.util.List;

@Service
public interface RoleService {

	public List<Role> getAllRoles();

	public Role getById(int id);

	public Role getRole(String rolename) throws RoleNotFoundException;
}
