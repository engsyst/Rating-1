package ua.nure.indplan.entity.autoplaning;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "discipline")
@NamedQuery(name = "Discipline.findAll", query = "SELECT d FROM Discipline d")
public class Discipline implements Serializable {

    private int id;
    private String name;
    private Plan plan;
    private Set<DisciplineHasAttribute> disciplineHasAttributes;
    private Set<DisciplineHasCategory> disciplineHasCategories;

    public Discipline(int id, String name, Plan plan, Set<DisciplineHasAttribute> disciplineHasAttributes,
                      Set<DisciplineHasCategory> disciplineHasCategories) {

        this.id = id;
        this.name = name;
        this.plan = plan;
        this.disciplineHasAttributes = disciplineHasAttributes;
        this.disciplineHasCategories = disciplineHasCategories;
    }

    public Discipline() {

    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.category")
    public Set<DisciplineHasCategory> getDisciplineHasCategories() {
        return disciplineHasCategories;
    }

    public void setDisciplineHasCategories(Set<DisciplineHasCategory> disciplineHasCategories) {
        this.disciplineHasCategories = disciplineHasCategories;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "pk.disciplineAttribute")
    public Set<DisciplineHasAttribute> getDisciplineHasAttributes() {
        return disciplineHasAttributes;
    }

    public void setDisciplineHasAttributes(Set<DisciplineHasAttribute> disciplineHasAttributes) {
        this.disciplineHasAttributes = disciplineHasAttributes;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToOne
    @JoinColumn(name = "plan_id", nullable = false)
    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }
}
