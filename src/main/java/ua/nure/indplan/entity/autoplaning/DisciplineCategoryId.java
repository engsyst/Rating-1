package ua.nure.indplan.entity.autoplaning;

import ua.nure.indplan.entity.Category;

import java.io.Serializable;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DisciplineCategoryId implements Serializable {

	private static final long serialVersionUID = 1L;
	private Discipline discipline;
    private Category category;

    public DisciplineCategoryId() {

    }

    public DisciplineCategoryId(Discipline discipline, Category category) {

        this.discipline = discipline;
        this.category = category;
    }

    @ManyToOne
    public Discipline getDiscipline() {
        return discipline;
    }

    public void setDiscipline(Discipline discipline) {
        this.discipline = discipline;
    }

    @ManyToOne
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

}
