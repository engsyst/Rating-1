package net.ua.controller;

import net.ua.entity.Employee;
import net.ua.entity.Role;
import net.ua.entity.User;
import net.ua.service.EmployeeService;
import net.ua.service.RoleService;
import net.ua.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
@RequestMapping(value = "/user")
public class UserController {

    Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        logger.info("getAll:GET-getAllUsers");
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "userAll";
    }

    /**
     * Go to save page. Send to page lists of employees and roles, that need to fill information about user.
     * GET method load page and fill some fields automatically.
     *
     * @param model provides relations with java and thymeleaf
     * @return used add page
     */
    @RequestMapping(value = "/save", method = RequestMethod.GET)
    public String userSavePage(Model model) {
        logger.info("save:GET:userSavePage");
        List<Employee> employees = employeeService.getAll();
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("user", new User());
        model.addAttribute("employees", employees);
        model.addAttribute("roles", roles);
        return "userAdd";
    }

    /**
     * Save user from thymeleaf. If save gone successfully send message ok
     *
     * @param user user from thymeleaf
     * @param bindingResult show thymeleaf errors
     * @param redirectAttributes send message to thymeleaf in redirect
     * @return save page
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String userSave(@Valid @ModelAttribute User user, BindingResult bindingResult,
                RedirectAttributes redirectAttributes) {
        logger.info("save:POST:userSave");
        if (bindingResult.hasErrors()) {
            logger.error(bindingResult.toString());
            return "userAdd";
        } else {
            userService.addUser(user);
            String message = "Пользователь успешно добавлен";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/user/save";
        }
    }

    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUser(
            @RequestParam(value = "id", required = true) Integer id,
            @RequestParam(value = "phase", required = true) String phase) {
        logger.info("delete:GET:deleteUser");
        User user = userService.getById(id);
        userService.deleteUser(user);
        return "redirect:/user/getAll";
    }

    /**
     * Go to update page. Get user from table and fill fields in new page.
     * GET method only returns page
     *
     * @param id user id
     * @param model provides relations with java and thymeleaf
     * @return user edit page
     */
    @RequestMapping(value = "/update", method = RequestMethod.GET)
    public String updateUserPage(@RequestParam(value = "id", required = true) Integer id,
            Model model) {
        logger.info("update:GET:updateUserPage");
        User user = userService.getById(id);
        List<Employee> employees = employeeService.getAll();
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("employees", employees);
        model.addAttribute("roles", roles);
        model.addAttribute("user", user);
        return "userEdit";
    }

    /**
     * Update user from thymeleaf.
     *
     * @param user user
     * @return redirect on list of users page
     */
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updateEmployee(@ModelAttribute User user) {
        userService.updateUser(user);
        return "redirect:/user/getAll";
    }
}
