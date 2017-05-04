package ua.nure.indplan.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.Set;


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
	private String title;
	private Set<Category> categories;
	private Set<Employee> employees;
	private WorkType type;

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


	@Column(length=255)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}


	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}


	@Column(length=1000, nullable=true)
	public String getDoc() {
		return this.doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}


	@Column(nullable=false, length=255)
	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}


	//bi-directional many-to-many association to Category
	@ManyToMany(mappedBy="works", fetch=FetchType.EAGER)
	public Set<Category> getCategories() {
		return this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}


	//bi-directional many-to-many association to Employee
	@ManyToMany(mappedBy="works", fetch=FetchType.EAGER)
	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}


	//bi-directional many-to-one association to Worktype
	@ManyToOne
	@JoinColumn(name="type_id", nullable=false)
	public WorkType getType() {
		return this.type;
	}

	public void setType(WorkType worktype) {
		this.type = worktype;
	}

}