package ua.nure.indplan.service;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Employee;

import java.util.List;

@Service
public interface EmployeeService {

    public List<Employee> getAll();

    public void add(Employee employee);

    public void delete(Employee employee);

    public Employee getById(int id);

    public void update(Employee employee);
}
