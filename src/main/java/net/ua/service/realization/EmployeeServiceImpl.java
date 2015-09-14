package net.ua.service.realization;


import net.ua.dao.EmployeeDao;
import net.ua.entity.Employee;
import net.ua.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public List<Employee> getAll() {
        return employeeDao.getAll();
    }

    @Override
    public void addEmployee(Employee employee) {
        employeeDao.addEmployee(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        employeeDao.deleteEmployee(employee);
    }

    @Override
    public Employee getById(int id) {
        return employeeDao.getById(id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        employeeDao.updateEmployee(employee);
    }
}
