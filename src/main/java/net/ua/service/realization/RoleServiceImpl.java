package net.ua.service.realization;

import net.ua.dao.RoleDao;
import net.ua.entity.Role;
import net.ua.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class RoleServiceImpl implements RoleService{

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
}
