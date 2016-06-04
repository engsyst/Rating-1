package net.ua.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "discipline")
public class Discipline implements Serializable {

	private static final long serialVersionUID = -76504159431374169L;

	@Id
	@GeneratedValue
	@Column(name = "DisciplineId")
	private int disciplineId;

	@Column(name = "Name")
	private String name;

	public int getDisciplineId() {
		return disciplineId;
	}

	public void setDisciplineId(int disciplineId) {
		this.disciplineId = disciplineId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Discipline{" + "disciplineId=" + disciplineId + ", name=" + name + "}";
	}

}
