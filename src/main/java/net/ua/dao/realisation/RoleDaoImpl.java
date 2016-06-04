package net.ua.dao.realisation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.ua.dao.RoleDao;
import net.ua.entity.Role;

public class RoleDaoImpl implements RoleDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Role> getAllRoles() {
        return getSession().createQuery("from Role").list();
    }

    @Override
    public Role getById(int id) {
        return (Role) getSession().get(Role.class, id);
    }
}
