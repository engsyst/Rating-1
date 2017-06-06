package ua.nure.indplan.service.realization;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Student;
import ua.nure.indplan.service.StudentService;

@Service
public class StudentFormatter implements Formatter<Student> {
    @Autowired
    StudentService stService;   //Service -> DB

	@Override
	public String print(Student object, Locale locale) {
		return object != null ? object.getId() + "" : "";
	}

	@Override
	public Student parse(String text, Locale locale) throws ParseException {
		Integer id = Integer.valueOf(text);
		Student ct = id == 0 ? new Student() : this.stService.getById(id); //return Student object form DB;
        return ct;
	}

}
