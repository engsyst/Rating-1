package ua.nure.indplan.service.realization;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Student;
import ua.nure.indplan.entity.VMStudent;

@Service
public class StudentAdapter {

	public VMStudent get(Student stud) {
		return new VMStudent(stud);
	}

	public List<VMStudent> get(Collection<Student> studs) {
		List<VMStudent> res = new ArrayList<>();
		for (Student student : studs) {
			res.add(new VMStudent(student));
		}
		return res;
	}
}
