package ua.nure.indplan.dao;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.nure.indplan.entity.Employee;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface EmployeeDAO extends CrudRepository<Employee, Integer> {

    public List<Employee> findAll();

}
