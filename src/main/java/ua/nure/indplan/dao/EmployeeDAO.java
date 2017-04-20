package ua.nure.indplan.dao;


import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EmployeeDAO {

    public List<Employee> getAll();

    public void addEmployee(Employee employee);

    public void deleteEmployee(Employee employee);

    public Employee getById(int id);

    public void updateEmployee(Employee employee);
}
