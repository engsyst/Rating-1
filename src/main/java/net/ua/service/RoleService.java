package net.ua.service;

import net.ua.entity.Role;
import org.springframework.stereotype.Service;

import java.util.List;

public interface RoleService {

    public List<Role> getAllRoles();

    public Role getById(int id);
}
