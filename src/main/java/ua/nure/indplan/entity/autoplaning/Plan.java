package ua.nure.indplan.entity.autoplaning;

import ua.nure.indplan.entity.Employee;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "plan")
@NamedQuery(name = "Plan.findAll", query = "SELECT p FROM Plan p")
public class Plan {

    private int id;
    private Employee employee;
    private double rate;
    private int startYear;

    public Plan() {
    }

    public Plan(int id, Employee employee, double rate, int startYear) {
        this.id = id;
        this.employee = employee;
        this.rate = rate;
        this.startYear = startYear;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true, nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @ManyToOne
    @JoinColumn(name = "employee_id", nullable = false)
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }
}
