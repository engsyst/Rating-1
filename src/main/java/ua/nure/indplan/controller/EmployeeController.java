package ua.nure.indplan.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.nure.indplan.entity.Employee;
import ua.nure.indplan.service.EmployeeService;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {


    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Employee> employees = employeeService.getAll();
        model.addAttribute("employees", employees);
        return "employeeAll";
    }

    /**
     * Go to save page. Send to page empty employee (thymeleaf it requires)
     * GET method load page and fill all fields in null
     *
     * @param model provides relations with java and thymeleaf
     * @return employee add page
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String employeeAddPage(Model model) {
        model.addAttribute("employee", new Employee());
        return "employeeAdd";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addEmployee(@Valid @ModelAttribute Employee employee, RedirectAttributes redirectAttributes, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "employeeAdd";
        } else {
            employeeService.addEmployee(employee);
            String message = "Сотрудник успешно добавлен";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/employee/save";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteEmployee(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "phase", required = true) String phase,
            Model model) {
        Employee employee = employeeService.getById(id);
        employeeService.deleteEmployee(employee);
        model.addAttribute("message", "Запись успешно удалена");
        return "redirect:/employee/getAll";
    }

    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateEmployeePage(@RequestParam(value = "id", required = true) Integer id, Model model) {
        Employee employee = employeeService.getById(id);
        model.addAttribute("employee", employee);
        return "employeeEdit";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute Employee employee, Model model) {
        employeeService.updateEmployee(employee);
        return "redirect:/employee/getAll";
    }
}
