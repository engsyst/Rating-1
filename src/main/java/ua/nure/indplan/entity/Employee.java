package ua.nure.indplan.entity;

import java.io.Serializable;
import javax.persistence.*;

import com.mysql.jdbc.StringUtils;

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
	@ManyToMany(fetch=FetchType.EAGER, cascade=CascadeType.ALL)
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

	@Transient
	public String getSNP() {
		if (StringUtils.isNullOrEmpty(surname)) {
			return "";
		}
		return new StringBuilder().append(StringUtils.isNullOrEmpty(surname) ? "" : surname)
				.append(" ").append(StringUtils.isNullOrEmpty(name) ? "" : name.charAt(0))
				.append(".").append(StringUtils.isNullOrEmpty(patronymic) ? "" : patronymic.charAt(0))
				.append(".").toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((academicTitle == null) ? 0 : academicTitle.hashCode());
		result = prime * result + ((degree == null) ? 0 : degree.hashCode());
		result = prime * result + ((jobTitle == null) ? 0 : jobTitle.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((patronymic == null) ? 0 : patronymic.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (academicTitle == null) {
			if (other.academicTitle != null)
				return false;
		} else if (!academicTitle.equals(other.academicTitle))
			return false;
		if (degree == null) {
			if (other.degree != null)
				return false;
		} else if (!degree.equals(other.degree))
			return false;
		if (jobTitle == null) {
			if (other.jobTitle != null)
				return false;
		} else if (!jobTitle.equals(other.jobTitle))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (patronymic == null) {
			if (other.patronymic != null)
				return false;
		} else if (!patronymic.equals(other.patronymic))
			return false;
		if (surname == null) {
			if (other.surname != null)
				return false;
		} else if (!surname.equals(other.surname))
			return false;
		return true;
	}


	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=");
		builder.append(id);
		builder.append(", surname=");
		builder.append(surname);
		builder.append(", name=");
		builder.append(name);
		builder.append(", academicTitle=");
		builder.append(academicTitle);
		builder.append(", patronymic=");
		builder.append(patronymic);
		builder.append(", degree=");
		builder.append(degree);
		builder.append(", jobTitle=");
		builder.append(jobTitle);
		builder.append("]");
		return builder.toString();
	}

}