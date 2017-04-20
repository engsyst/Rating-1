package net.ua.dao.realisation;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import net.ua.dao.GroupDao;
import net.ua.entity.Group;

public class GroupDaoImpl implements GroupDao {

    @Autowired
    SessionFactory sessionFactory;

    private Session getSession() {
        return sessionFactory.getCurrentSession();
    }

    @SuppressWarnings("unchecked")
	@Override
    public List<Group> getAllGroups() {
        return getSession().createQuery("from Group").list();
    }

    @Override
    public void addGroup(Group group) {
        getSession().save(group);
    }

    @Override
    public Group getById(int id) {
        return (Group) getSession().get(Group.class, id);
    }

    @Override
    public void deleteGroup(Group group) {
        getSession().delete(group);
    }

    @Override
    public void updateGroup(Group group) {
        getSession().update(group);
    }
}
