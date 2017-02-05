package net.ua.dao;


import net.ua.entity.Employee;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

public interface EmployeeDAO {

    public List<Employee> getAll();

    public void addEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public Employee getById(int id);

    public void updateEmployee(Employee employee);
}
