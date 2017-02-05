package net.ua.dao.realisation;

import net.ua.dao.RoleDao;
import net.ua.entity.Role;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RoleDaoImpl extends AbstractSessionDAO  implements RoleDao {

    @Override
    public List<Role> getAllRoles() {
        return getSession().createQuery("from Role").list();
    }

    @Override
    public Role getById(int id) {
        return (Role) getSession().get(Role.class, id);
    }
}
