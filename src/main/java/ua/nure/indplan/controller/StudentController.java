package net.ua.controller;

import net.ua.entity.Group;
import net.ua.entity.Student;
import net.ua.service.GroupService;
import net.ua.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/student")
public class StudentController {

    @Autowired
    GroupService groupService;

    @Autowired
    StudentService studentService;

    @RequestMapping(value = "/allGroups", method = RequestMethod.GET)
    public String getAllGroups(Model model) {
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);
        return "groupAll";
    }

    @RequestMapping(value = "/saveGroup", method = RequestMethod.GET)
    public String addGroupPage(Model model) {
        model.addAttribute("group", new Group());
        return "groupAdd";
    }

    @RequestMapping(value = "/saveGroup", method = RequestMethod.POST)
    public String addGroup(@Valid @ModelAttribute Group group,
            RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "groupAdd";
        } else {
            groupService.addGroup(group);
            String message = "Группа успешно добавлена";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/student/saveGroup";
        }
    }

    @RequestMapping(value = "/deleteGroup", method = RequestMethod.GET)
    public String deleteGroup(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "phase", required = true) String phase,
            Model model, RedirectAttributes redirectAttributes) {
        Group group = groupService.getById(id);
        groupService.deleteGroup(group);
        redirectAttributes.addFlashAttribute("message", "Запись успешно удалена");
        return "redirect:/student/allGroups";
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.GET)
    public String updateGroupPage(@RequestParam(value = "id", required = true) Integer id,
            Model model) {
        Group group = groupService.getById(id);
        model.addAttribute("group", group);
        return "groupEdit";
    }

    @RequestMapping(value = "/updateGroup", method = RequestMethod.POST)
    public String updateGroup(@ModelAttribute Group group) {
        groupService.updateGroup(group);
        return "redirect:/student/allGroups";
    }

    @RequestMapping(value = "/allStudents", method = RequestMethod.GET)
    public String getAllStudents(Model model) {
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "studentAll";
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.GET)
    public String addStudentPage(Model model) {
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("groups", groups);
        model.addAttribute("selectedGroup", new Group());
        model.addAttribute("student", new Student());
        return "studentAdd";
    }

    @RequestMapping(value = "/saveStudent", method = RequestMethod.POST)
    public String addStudent(@Valid @ModelAttribute Student student, @ModelAttribute Group selectedGroup,
            RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "studentAdd";
        } else {
            student.getGroup().add(selectedGroup);
            studentService.addStudent(student);
            String message = "Студент успешно добавлен";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/student/saveStudent";
        }
    }

    @RequestMapping(value = "/deleteStudent", method = RequestMethod.GET)
    public String deleteStudent(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "phase", required = true) String phase,
            RedirectAttributes redirectAttributes) {
        Student student = studentService.getById(id);
        studentService.deleteStudent(student);
        redirectAttributes.addFlashAttribute("message", "Запись успешно удалена");
        return "redirect:/student/allStudents";
    }

    @RequestMapping(value = "/updateStudent", method = RequestMethod.GET)
    public String updateStudentPage(@RequestParam(value = "id", required = true) Integer id,
            Model model) {
        Student student = studentService.getById(id);
        List<Group> groups = groupService.getAllGroups();
        model.addAttribute("student", student);
        model.addAttribute("groups", groups);
        return "studentEdit";
    }
}
