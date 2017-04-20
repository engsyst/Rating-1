package ua.nure.indplan.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String academicTitle;
	private String degree;
	private String jobTitle;
	private String name;
	private String patronymic;
	private String surname;
	private Set<Work> works;
	private Set<User> users;

	public Employee() {
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


	@Column(length=45)
	public String getAcademicTitle() {
		return this.academicTitle;
	}

	public void setAcademicTitle(String academicTitle) {
		this.academicTitle = academicTitle;
	}


	@Column(length=45)
	public String getDegree() {
		return this.degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}


	@Column(length=45)
	public String getJobTitle() {
		return this.jobTitle;
	}

	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}


	@Column(nullable=false, length=32)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Column(nullable=false, length=32)
	public String getPatronymic() {
		return this.patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}


	@Column(nullable=false, length=32)
	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}


	//bi-directional many-to-many association to Work
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(
		name="employee_has_work"
		, joinColumns={
			@JoinColumn(name="employee_id", nullable=false)
			}
		, inverseJoinColumns={
			@JoinColumn(name="work_id", nullable=false)
			}
		)
	public Set<Work> getWorks() {
		return this.works;
	}

	public void setWorks(Set<Work> works) {
		this.works = works;
	}


	//bi-directional many-to-one association to User
	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	public Set<User> getUsers() {
		return this.users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public User addUser(User user) {
		getUsers().add(user);
		user.setEmployee(this);

		return user;
	}

	public User removeUser(User user) {
		getUsers().remove(user);
		user.setEmployee(null);

		return user;
	}

}