package ua.nure.indplan.service.realization;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Service;

import ua.nure.indplan.entity.Role;
import ua.nure.indplan.service.RoleService;

@Service
public class RoleFormatter implements Formatter<Role> {
    @Autowired
    RoleService roleService;   //Service -> DB

	@Override
	public String print(Role object, Locale locale) {
		return object != null ? object.getId() + "" : "";
	}

	@Override
	public Role parse(String text, Locale locale) throws ParseException {
		Integer id = Integer.valueOf(text);
		Role r = id == 0 ? new Role() : this.roleService.getById(id); //return Role object form DB;
        return r;
	}

}
