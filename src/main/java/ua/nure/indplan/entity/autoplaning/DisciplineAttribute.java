package ua.nure.indplan.entity.autoplaning;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "discipline_attribute")
@NamedQuery(name = "DisciplineAttribute.findAll", query = "SELECT da FROM DisciplineAttribute da")
public class DisciplineAttribute {

    private int id;
    private String name;

    public DisciplineAttribute() {

    }

    public DisciplineAttribute(int id, String name) {

        this.id = id;
        this.name = name;
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
}
