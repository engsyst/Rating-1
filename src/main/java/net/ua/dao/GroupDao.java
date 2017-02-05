package net.ua.dao;


import net.ua.entity.Group;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface GroupDao {

    public List<Group> getAllGroups();

    public void addGroup(Group group);

    public Group getById(int id);

    public void deleteGroup(Group group);

    public void updateGroup(Group group);
}
