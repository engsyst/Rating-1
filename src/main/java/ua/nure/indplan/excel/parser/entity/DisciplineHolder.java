package ua.nure.indplan.excel.parser.entity;

import java.util.List;

public class DisciplineHolder extends EntityWithHours {

    private List<Discipline> disciplines;
    private String semester;

    public List<Discipline> getDisciplines() {
        return disciplines;
    }

    public DisciplineHolder setDisciplines(List<Discipline> disciplines) {
        this.disciplines = disciplines;
        return this;
    }

    public String getSemester() {
        return semester;
    }

    public DisciplineHolder setSemester(String semester) {
        this.semester = semester;
        return this;
    }

}
