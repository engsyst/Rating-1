package net.ua.dao.realisation;

import net.ua.dao.GroupDao;
import net.ua.entity.Group;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class GroupDaoImpl extends AbstractSessionDAO  implements GroupDao {

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
