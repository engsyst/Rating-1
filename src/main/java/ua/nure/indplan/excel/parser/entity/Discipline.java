package ua.nure.indplan.excel.parser.entity;

import java.util.ArrayList;
import java.util.List;

public class Discipline extends EntityWithHours {

    private String semester;
    private List<String> groups = new ArrayList<>();
    private int studentsCount;
    private String controlType = "";
    private String name;

    public String getSemester() {
        return semester;
    }

    public Discipline setSemester(String semester) {

        this.semester = semester;
        return this;
    }

    public List<String> getGroups() {
        return groups;
    }

    public Discipline setGroups(List<String> groups) {
        this.groups = groups;
        return this;
    }

    public int getStudentsCount() {
        return studentsCount;
    }

    public Discipline setStudentsCount(int studentsCount) {
        this.studentsCount = studentsCount;
        return this;
    }

    public String getControlType() {
        return controlType;
    }

    public Discipline setControlType(String controlType) {
        this.controlType = controlType;
        return this;
    }

    public String getName() {
        return name;
    }

    public Discipline setName(String name) {
        this.name = name;
        return this;
    }
}
