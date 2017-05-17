package ua.nure.indplan.validation;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.nure.indplan.entity.Work;

@Service
public class WorkValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return  clazz.isInstance(new Work());
	}

	@Override
	public void validate(Object target, Errors errors) {
		Work w = (Work) target;
		String t = w.getTitle();
		if (t == null || t.trim().length() == 0) {
			errors.rejectValue("title", "work.title.hint", "title is empty");
		}
		t = w.getAuthor();
		if (t == null || t.trim().length() == 0) {
			errors.rejectValue("author", "work.author.hint", "author is empty");
		}
		t = w.getOutput();
		if (t == null || t.trim().length() == 0) {
			errors.rejectValue("output", "work.output.hint", "output is empty");
		}
		if (w.getEmployees() == null || w.getEmployees().size() == 0) {
			errors.rejectValue("employees", "work.employees.hint", "employees is empty");
		}
		if (w.getTypes() == null || w.getTypes().size() == 0) {
			errors.rejectValue("types", "work.types.hint", "types is empty");
		}
		if (w.getCategory() == null || w.getCategory().getId() == 0) {
			errors.rejectValue("category", "work.category.hint", "category is empty");
		}
	}

}
