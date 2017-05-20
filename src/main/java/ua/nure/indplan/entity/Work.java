package ua.nure.indplan.entity;


import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the work database table.
 * 
 */
@Entity
@Table(name="work")
@NamedQuery(name="Work.findAll", query="SELECT w FROM Work w")
public class Work implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String author;
	private Date date;
	private String doc;
	private String output;
	private String title;
	private Set<Employee> employees;
	private Category category;
	private Set<WorkType> types;

	public Work() {
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


	@Column(nullable=false, length=255)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	@Temporal(TemporalType.DATE)
	@Column(nullable=false)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Column(length=1000)
	public String getDoc() {
		return this.doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}


	@Column(nullable=false, length=1000)
	public String getOutput() {
		return this.output;
	}

	public void setOutput(String output) {
		this.output = output;
	}


	@Column(nullable=false, length=255, unique=true)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-many association to Employee
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="employee_has_work"
			, joinColumns={
				@JoinColumn(name="work_id", nullable=false)
				}
			, inverseJoinColumns={
				@JoinColumn(name="employee_id", nullable=false)
				}
			)
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	//bi-directional many-to-one association to Category
	@ManyToOne
	@JoinColumn(name="category_id", nullable=false)
	public Category getCategory() {
		return this.category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}


	//bi-directional many-to-many association to WorkType
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
			name="work_has_type"
			, joinColumns={
				@JoinColumn(name="work_id", nullable=false)
				}
			, inverseJoinColumns={
				@JoinColumn(name="type_id", nullable=false)
				}
			)
	public Set<WorkType> getTypes() {
		return this.types;
	}

	public void setTypes(Set<WorkType> types) {
		this.types = types;
	}


	public void addToEmployees() {
		for (Employee e : getEmployees()) {
			e.getWorks().add(this);
		}
	}


	public void addToTypes() {
		for (WorkType t : getTypes()) {
			t.getWorks().add(this);
		}
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((date == null) ? 0 : date.hashCode());
		result = prime * result + ((doc == null) ? 0 : doc.hashCode());
		result = prime * result + ((output == null) ? 0 : output.hashCode());
		result = prime * result + ((title == null) ? 0 : title.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Work))
			return false;
		Work other = (Work) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (date == null) {
			if (other.date != null)
				return false;
		} else if (!date.equals(other.date))
			return false;
		if (doc == null) {
			if (other.doc != null)
				return false;
		} else if (!doc.equals(other.doc))
			return false;
		if (output == null) {
			if (other.output != null)
				return false;
		} else if (!output.equals(other.output))
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Work [title=");
		builder.append(title);
		builder.append(", author=");
		builder.append(author);
		builder.append(", date=");
		builder.append(", output=");
		builder.append(output);
		builder.append(date);
		builder.append(", doc=");
		builder.append(doc);
		builder.append("] =");
		builder.append(super.toString());
		return builder.toString();
	}
	
}