package ua.nure.indplan.validation;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.nure.indplan.entity.Role;
import ua.nure.indplan.entity.User;

@Service
public class UserValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return clazz.isInstance(new User());
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;
		if (StringUtils.isEmpty(u.getUsername()) || StringUtils.containsWhitespace(u.getUsername())) {
			errors.rejectValue("username", "user.username.hint", new Object[] {1, 16}, "login is empty");
		}
		if (StringUtils.isEmpty(u.getPassword())) {
			errors.rejectValue("password", "user.password.hint", new Object[] {1, 32}, "password is empty");
		}
		if (u.getEmployee() == null || u.getEmployee().getId() == 0) {
			errors.rejectValue("employee", "user.employee.hint", "emplloyee is empty");
		}
		if (u.getRoles() == null || u.getRoles().size() == 0 || u.getRoles().toArray(new Role[0])[0].getId() == 0) {
			errors.rejectValue("roles", "user.roles.hint", "role is empty");
		} 
	}

}
