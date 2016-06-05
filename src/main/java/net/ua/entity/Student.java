package net.ua.entity;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "student")
public class Student implements Serializable {

	private static final long serialVersionUID = 7609261853417819575L;

	@Id
	@GeneratedValue
	@Column(name = "id", nullable = false, length = 11)
	private int studentId;

	@Column(name = "Name", length = 32)
	@Pattern(regexp = "[А-ЯЁ][а-яё]{1,32}")
	private String name;

	@Column(name = "Patronymic", length = 32)
	@Pattern(regexp = "[А-ЯЁ][а-яё]{1,32}")
	private String patronymic;

	@Column(name = "Surname", length = 32)
	@Pattern(regexp = "[А-ЯЁ][а-яё]{1,32}")
	private String surname;

	@Column(name = "Studentcol", length = 45)
	@Pattern(regexp = "[а-я-А-Я]{0,45}")
	private String studentcol;

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "student_group", joinColumns = {
			@JoinColumn(name = "student_id", referencedColumnName = "id") }, inverseJoinColumns = {
					@JoinColumn(name = "group_id", referencedColumnName = "id") })
	private Set<Group> group = new HashSet<>(0);

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPatronymic() {
		return patronymic;
	}

	public void setPatronymic(String patronymic) {
		this.patronymic = patronymic;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getStudentcol() {
		return studentcol;
	}

	public void setStudentcol(String studentcol) {
		this.studentcol = studentcol;
	}

	public Set<Group> getGroup() {
		return group;
	}

	public void setGroup(Set<Group> group) {
		if (this.group.isEmpty())
			this.group = new HashSet<>();
		this.group = group;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Student))
			return false;

		Student student = (Student) o;

		if (getStudentId() != student.getStudentId())
			return false;
		if (getName() != null ? !getName().equals(student.getName()) : student.getName() != null)
			return false;
		if (getPatronymic() != null ? !getPatronymic().equals(student.getPatronymic())
				: student.getPatronymic() != null)
			return false;
		if (getSurname() != null ? !getSurname().equals(student.getSurname()) : student.getSurname() != null)
			return false;
		return !(getStudentcol() != null ? !getStudentcol().equals(student.getStudentcol())
				: student.getStudentcol() != null);

	}

	@Override
	public int hashCode() {
		int result = getStudentId();
		result = 31 * result + (getName() != null ? getName().hashCode() : 0);
		result = 31 * result + (getPatronymic() != null ? getPatronymic().hashCode() : 0);
		result = 31 * result + (getSurname() != null ? getSurname().hashCode() : 0);
		result = 31 * result + (getStudentcol() != null ? getStudentcol().hashCode() : 0);
		return result;
	}

	@Override
	public String toString() {
		return "Student{" + "studentId=" + studentId + ", name='" + name + '\'' + ", patronymic='" + patronymic + '\''
				+ ", surname='" + surname + '\'' + ", studentcol='" + studentcol + '\'' + '}';
	}
}
