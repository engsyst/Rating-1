package net.ua.dao.realisation;

import net.ua.dao.EmployeeDAO;
import net.ua.entity.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDAOImpl extends AbstractSessionDAO  implements EmployeeDAO {

    Logger logger = LoggerFactory.getLogger(EmployeeDAOImpl.class);

    @Override
    public List<Employee> getAll() {
        logger.info("dao: get all employees");
        return getSession().createQuery("from Employee").list();
    }

    @Override
    public void addEmployee(Employee employee) {
        logger.info("dao: add employee");
        getSession().save(employee);
    }

    @Override
    public void deleteEmployee(Employee employee) {
        logger.info("dao: delete employee");
        getSession().delete(employee);
    }

    @Override
    public Employee getById(int id) {
        logger.info("dao: get by id");
        return (Employee) getSession().get(Employee.class, id);
    }

    @Override
    public void updateEmployee(Employee employee) {
        logger.info("dao: update employee");
        getSession().update(employee);
    }
}
