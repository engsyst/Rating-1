package net.ua.controller;


import net.ua.entity.Employee;
import net.ua.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {

    Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        logger.info("getAll:GET-getAllEmployees");
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employeeAll";
    }

    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String employeeAddPage(Model model) {
        logger.info("save:GET:load save page");
        model.addAttribute("employee", new Employee());
        return "employeeAdd";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addEmployee(@Valid @ModelAttribute Employee employee,  Model model) {
        logger.info("save:POST:add new empoyee");
        employeeService.addEmployee(employee);
        return "redirect:/employee/save";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEmployee(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "phase", required = true) String phase,
            Model model) {
        logger.info("delete:GET:delete employee");
        if (id == null)
            logger.error("delete:GET: id = null");
        Employee employee = employeeService.getById(id);
        if (employee == null)
            logger.error("delete:GET: employee = null");
        employeeService.deleteEmployee(employee);
        model.addAttribute("message", "Запись успешно удалена");
        return "redirect:/employee/getAll";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateEmployeePage(@RequestParam(value = "id", required = true) Integer id, Model model) {
        logger.info("update:GET:load update page");
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "employeeEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute Employee employee, Model model) {
        logger.info("update:POST: update employee");
        employeeService.updateEmployee(employee);
        return "redirect:/employee/getAll";
    }
}
