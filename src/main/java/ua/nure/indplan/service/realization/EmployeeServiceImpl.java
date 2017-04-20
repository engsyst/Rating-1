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
        return employeeDAO.getAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDAO.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDAO.deleteEmployee(employee);
    }

    @Override
    public Employee getById(int id) {
        return employeeDAO.getById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDAO.updateEmployee(employee);
    }
}
