package ua.nure.indplan.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the worktype database table.
 * 
 */
@Entity
@Table(name="worktype")
@NamedQuery(name="Worktype.findAll", query="SELECT w FROM Worktype w")
public class Worktype implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private Set<Work> works;

	public Worktype() {
	}


	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}


	@Column(unique=true, nullable=false, length=255)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-one association to Work
	@OneToMany(mappedBy="worktype", fetch=FetchType.EAGER)
	public Set<Work> getWorks() {
		return this.works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}

	public Work addWork(Work work) {
		getWorks().add(work);
		work.setWorktype(this);

		return work;
	}

	public Work removeWork(Work work) {
		getWorks().remove(work);
		work.setWorktype(null);

		return work;
	}

}