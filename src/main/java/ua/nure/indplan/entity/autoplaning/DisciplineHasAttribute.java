package ua.nure.indplan.entity.autoplaning;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "discipline_has_attribute")
@NamedQuery(name = "DisciplineHasAttribute.findAll", query = "SELECT ad FROM DisciplineHasAttribute ad")
public class DisciplineHasAttribute implements Serializable {

	private static final long serialVersionUID = 1L;
	private AttributeDisciplineId pk;
    private String value;

    public DisciplineHasAttribute() {

    }

    public DisciplineHasAttribute(AttributeDisciplineId pk, String value) {
        this.pk = pk;
        this.value = value;
    }

    @EmbeddedId
    public AttributeDisciplineId getPk() {
        return pk;
    }

    public void setPk(AttributeDisciplineId pk) {
        this.pk = pk;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
