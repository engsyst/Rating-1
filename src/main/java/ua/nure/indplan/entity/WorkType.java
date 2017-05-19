package ua.nure.indplan.entity;

import java.io.Serializable;
import javax.persistence.*;

import java.util.LinkedHashSet;
import java.util.Set;


/**
 * The persistent class for the worktype database table.
 * 
 */
@Entity
@Table(name="worktype")
@NamedQuery(name="WorkType.findAll", query="SELECT w FROM WorkType w")
public class WorkType implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String title;
	private Set<Work> works;

	public WorkType() {
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


	@Column(nullable=false, length=255, unique=true)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-many association to Work
	@ManyToMany(mappedBy="types", fetch=FetchType.EAGER)
	public Set<Work> getWorks() {
		return this.works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof WorkType))
			return false;
		WorkType other = (WorkType) obj;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return title;
	}

}