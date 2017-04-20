package ua.nure.indplan.dao.realisation;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.RoleDao;
import ua.nure.indplan.entity.Role;
import ua.nure.indplan.exeptions.RoleNotFoundException;

public class RoleDaoImpl implements RoleDao {

	static Logger logger = LoggerFactory.getLogger(RoleDaoImpl.class);

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

	@Override
	public Role getRole(String roleName) throws RoleNotFoundException {
		logger.debug("RoleDAOImpl.getRole() - [" + roleName + "]");
		Query query = getSession().createQuery("from Role where rolename = :usersRole ");
		query.setString("usersRole", roleName);

		logger.debug(query.toString());
		if (query.list().size() == 0) {
			throw new RoleNotFoundException("Role [" + roleName + "] not found");
		} else {
			logger.debug("Role List Size: " + query.list().size());
			@SuppressWarnings("unchecked")
			List<Role> list = (List<Role>) query.list();
			Role roleObject = (Role) list.get(0);

			return roleObject;
		}
	}
}
