package net.ua.service;

import net.ua.entity.Group;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GroupService {

    public List<Group> getAllGroups();

    public void addGroup(Group group);

    public Group getById(int id);

    public void deleteGroup(Group group);

    public void updateGroup(Group group);
}
