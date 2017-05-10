package ua.nure.indplan.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;


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


	public Work(int id, String title, String author, Date date, WorkType type, Set<Category> categories,
			Set<Employee> employees, String doc) {
		super();
		this.id = id;
		this.title = title;
		this.author = author;
		this.date = date;
		this.type = type;
		this.categories = categories;
		this.employees = employees;
		this.doc = doc;
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


	@Autowired
	MessageSource messages;
	
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
	@ManyToMany(mappedBy="works", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public Set<Category> getCategories() {
		return categories == null ? new LinkedHashSet<>() : this.categories;
	}

	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}


	//bi-directional many-to-many association to Employee
	@ManyToMany(mappedBy="works", fetch=FetchType.EAGER, cascade=CascadeType.ALL)
	public Set<Employee> getEmployees() {
		return employees == null ? new LinkedHashSet<>() : employees;
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