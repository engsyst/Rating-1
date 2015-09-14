package net.ua.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "sgroup")
public class Group implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "GroupId", length = 11, nullable = false)
    private int groupId;

    @Column(name = "Title", length = 45)
    private String title;

    @ManyToMany(mappedBy = "group")
    private Set<Student> student;

    public int getGroupId() {
        return groupId;
    }

    public void setGroupId(int groupId) {
        this.groupId = groupId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Set<Student> getStudent() {
        return student;
    }

    public void setStudent(Set<Student> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Group{" +
                "groupId=" + groupId +
                ", title='" + title + '\'' +
                '}';
    }
}
