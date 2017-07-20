package ua.nure.indplan.service.realization;


import org.springframework.beans.factory.annotation.Autowired;

import ua.nure.indplan.dao.EmployeeDAO;
import ua.nure.indplan.entity.Employee;
import ua.nure.indplan.service.EmployeeService;

import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }

    @Override
    public void add(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    public void delete(Employee employee) {
        employeeDAO.delete(employee);
    }

    @Override
    public Employee getById(int id) {
        return employeeDAO.findOne(id);
    }

    @Override
    public void update(Employee employee) {
        employeeDAO.save(employee);
    }
}
