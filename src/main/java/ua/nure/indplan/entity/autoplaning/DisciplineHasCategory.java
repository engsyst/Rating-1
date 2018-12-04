package ua.nure.indplan.entity.autoplaning;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "discipline_has_category")
@NamedQuery(name = "DisciplineHasCategory.findAll", query = "SELECT dc FROM DisciplineHasCategory dc")
public class DisciplineHasCategory {

    private DisciplineCategoryId pk;
    private String someValues;

    public DisciplineHasCategory() {
    }

    public DisciplineHasCategory(DisciplineCategoryId pk, String someValues) {

        this.pk = pk;
        this.someValues = someValues;
    }

    @EmbeddedId
    public DisciplineCategoryId getPk() {
        return pk;
    }

    public void setPk(DisciplineCategoryId pk) {
        this.pk = pk;
    }

    public String getSomeValues() {
        return someValues;
    }

    public void setSomeValues(String someValues) {
        this.someValues = someValues;
    }
}
