package net.ua.entity;

import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee implements Serializable{

    @Id
    @GeneratedValue
    @Column(name = "EmployeeId", length = 11, nullable = false)
    private int employeeId;

    @Column(name = "Name", length = 32, nullable = false)
    @Pattern(regexp = "[А-ЯЁ][а-яё]{1,32}")
    @NotEmpty
    private String name;

    @Column(name = "Patronymic", length = 32, nullable = false)
    @Pattern(regexp = "[А-ЯЁ][а-яё]{1,32}")
    @NotEmpty
    private String patronymic;

    @Column(name = "Surname", length = 32, nullable = false)
    @Pattern(regexp = "[А-ЯЁ][а-яё]{1,32}")
    @NotEmpty
    private String surname;

    @Column(name = "JobTitle", length = 45)
    @Pattern(regexp = "[а-я-А-Я]{0,45}")
    private String jobTitle;

    @Column(name = "Degree", length = 45)
    @Pattern(regexp = "[а-я-А-Я]{0,45}")
    private String degree;

    @Column(name = "AcademicTitle", length = 45)
    @Pattern(regexp = "[а-я-А-Я]{0,45}")
    private String academicTitle;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<User> users;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
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

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getAcademicTitle() {
        return academicTitle;
    }

    public void setAcademicTitle(String academicTitle) {
        this.academicTitle = academicTitle;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    public String getSNP() {
        return surname + " " + name + " " + patronymic;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeId=" + employeeId +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", surname='" + surname + '\'' +
                ", jobTitle='" + jobTitle + '\'' +
                ", degree='" + degree + '\'' +
                ", academicTitle='" + academicTitle + '\'' +
                '}';
    }
}
