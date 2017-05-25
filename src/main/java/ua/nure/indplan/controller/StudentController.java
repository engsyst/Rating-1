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
import ua.nure.indplan.service.StudentService;

@RestController
@RequestMapping(value = "/stud")
public class StudentController {

 
    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);
        return  "workAll";
    }
    
    @RequestMapping(value = "/find", method = RequestMethod.GET)
    public List<Student> find(@RequestParam String name, @RequestParam Integer max) {
    	if (StringUtils.isEmpty(name)) {
    		return null;
    	}
    	if (max == null) {
    		return studentService.findByName(name);
		}
    	return studentService.findByName(name, max);
    }

}
