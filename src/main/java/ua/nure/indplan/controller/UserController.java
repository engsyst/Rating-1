package ua.nure.indplan.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ua.nure.indplan.entity.Employee;
import ua.nure.indplan.entity.Role;
import ua.nure.indplan.entity.User;
import ua.nure.indplan.service.EmployeeService;
import ua.nure.indplan.service.RoleService;
import ua.nure.indplan.service.UserService;
import ua.nure.indplan.validation.UserValidator;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    Logger log = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
	private UserValidator validator;

	@InitBinder
	private void initBinder(WebDataBinder binder) {
		binder.addValidators(validator);
	}
	
    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public String getAll(Model model) {
        log.info("getAll:GET-getAllUsers");
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
        log.info("save:GET:userSavePage");
        fillUserModel(model, new User(new Employee(), new Role()));
        return "userAdd";
    }

    void fillUserModel(Model model, User user) {
    	List<Employee> employees = employeeService.getAll();
    	employees.add(0, new Employee());
    	List<Role> roles = roleService.getAllRoles();
    	roles.add(0, new Role());
    	model.addAttribute("user", user);
    	model.addAttribute("employees", employees);
    	model.addAttribute("roles", roles);
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
                RedirectAttributes redirectAttributes, Model model) {
        log.info("save:POST:userSave");
        /*DataBinder binder = new DataBinder(user);
        binder.addValidators(new UserValidator());
         binder.validate();
        BindingResult result = binder.getBindingResult();
        if (result.hasErrors()) {
        	return "userAdd";
        }*/
        if (bindingResult.hasErrors()) {
            log.error(bindingResult.toString());
            fillUserModel(model, user);
            model.addAttribute("errorMessage", errorsToString(bindingResult));
            return "userAdd";
        } else {
            userService.addUser(user);
            String message = "Пользователь успешно добавлен";
            redirectAttributes.addFlashAttribute("message", message);
            return "redirect:/user/save";
        }
    }
    
    String errorsToString(BindingResult br) {
    	StringBuffer sb = new StringBuffer();
    	
    	if (br.hasFieldErrors("username")) {
    		sb.append("Не корректное имя пользователя. ");
    	}
    	if (br.hasFieldErrors("password")) {
    		sb.append("Не корректный пароль. ");
    	}
    	if (br.hasFieldErrors("roles")) {
    		sb.append("Не указана роль. ");
    	}
    	if (br.hasFieldErrors("employee")) {
    		sb.append("Не указан сотрудник. ");
    	}
    	return sb.toString();
    }

    /**
     * Go to update page. Get user from table and fill fields in new page.
     * GET method only returns page
     *
     * @param id user id
     * @param model provides relations with java and thymeleaf
     * @return user edit page
     */
    @RequestMapping(value = "/delete", method = RequestMethod.GET)
    public String deleteUserPage(@RequestParam(value = "id", required = true) Integer id,
            Model model) {
        log.info("delete:GET:deleteUserPage");
        User user = userService.getById(id);
        fillUserModel(model, user);
        return "userDetail";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String deleteUser(
    		@RequestParam(value = "id", required = true) Integer id
//            , @RequestParam(value = "phase", required = true) String phase
            ) {
        log.info("delete:POST:deleteUser");
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
        log.info("update:GET:updateUserPage");
        User user = userService.getById(id);
        List<Employee> employees = employeeService.getAll();
        List<Role> roles = roleService.getAllRoles();
        model.addAttribute("employees", employees);
        log.debug("updateUserPage: add attribute employees", employees);
        model.addAttribute("roles", roles);
        log.debug("updateUserPage: add attribute roles", roles);
        model.addAttribute("user", user);
        log.debug("updateUserPage: add attribute user", user);
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