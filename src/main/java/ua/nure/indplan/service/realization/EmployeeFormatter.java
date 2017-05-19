package ua.nure.indplan.service.realization;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Employee;
import ua.nure.indplan.entity.Role;
import ua.nure.indplan.service.EmployeeService;

@Service
public class EmployeeFormatter implements Formatter<Employee> {
    @Autowired
    EmployeeService employeeService;   //Service -> DB

	@Override
	public String print(Employee object, Locale locale) {
		return object != null ? object.getId() + "" : "";
	}

	@Override
	public Employee parse(String text, Locale locale) throws ParseException {
		Integer id = Integer.valueOf(text);
		Employee e = id == 0 ? new Employee() : this.employeeService.getById(id); //return Employee object form DB;
        return e; 
	}

}
