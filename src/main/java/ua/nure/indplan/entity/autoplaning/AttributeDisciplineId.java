package ua.nure.indplan.entity.autoplaning;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class AttributeDisciplineId implements Serializable {

    private Discipline discipline;
    private DisciplineAttribute disciplineAttribute;

    public AttributeDisciplineId() {

    }

    public AttributeDisciplineId(Discipline discipline, DisciplineAttribute disciplineAttribute) {

        this.discipline = discipline;
        this.disciplineAttribute = disciplineAttribute;
    }

    @ManyToOne
    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @ManyToOne
    public DisciplineAttribute getDisciplineAttribute() {
        return disciplineAttribute;
    }

    public void setDisciplineAttribute(DisciplineAttribute disciplineAttribute) {
        this.disciplineAttribute = disciplineAttribute;
    }
}
