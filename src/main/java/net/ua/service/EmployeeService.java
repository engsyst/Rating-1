package net.ua.service;

import net.ua.entity.Employee;
import org.springframework.stereotype.Service;

import java.util.List;

public interface EmployeeService {

    public List<Employee> getAll();

    public void addEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public Employee getById(int id);

    public void updateEmployee(Employee employee);
}
