package ua.nure.indplan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ua.nure.indplan.entity.Student;
import ua.nure.indplan.entity.VMStudent;
import ua.nure.indplan.service.StudentService;
import ua.nure.indplan.service.realization.StudentAdapter;

@RestController
@RequestMapping(value = "/stud")
public class StudentController {

 
    @Autowired
    StudentService studentService;

    @Autowired
    StudentAdapter studentAdapter;
    
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Student> students = studentService.findAll();
        model.addAttribute("students", students);
        return  "workAll";
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.POST)
    public List<VMStudent> find(@RequestParam String value, @RequestParam(required=false) Integer max) {
    	if (StringUtils.isEmpty(value)) {
    		return null;
    	}
    	if (max == null) {
    		return studentAdapter.get(studentService.findByName(value));
		}
    	return studentAdapter.get(studentService.findByName(value));
    }
}
