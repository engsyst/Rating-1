package ua.nure.indplan.validation;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import ua.nure.indplan.entity.Category;

@Service
public class CategoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return  clazz.isInstance(new Category());
	}

	@Override
	public void validate(Object target, Errors errors) {
		Category c = (Category) target;
//		if (c.getType() == null || c.getType().getId() == 0) {
//			errors.rejectValue("type", "category.type.hint", "type is empty");
//		}
		if (StringUtils.isEmpty(c.getTitle().trim())) {
			errors.rejectValue("title", "category.title.hint", new Object[] {1, 255}, "title is empty");
		}
		if (c.getTimerate() != null && c.getTimerate() < 0) {
			errors.rejectValue("timerate", "category.timerate.hint", "timerate incorrect");
		}
		String t = c.getTimeunit();
		if (!StringUtils.isEmpty(t) && StringUtils.isEmpty(t.trim())) {
			errors.rejectValue("timeunit", "field.null.notempty", "May by empty but can't contain spaces only");
		}
		if (c.getPerrate() != null && c.getPerrate() < 0) {
			errors.rejectValue("perrate", "category.perrate.hint", "timerate incorrect");
		}
		t = c.getPerunit();
		if (!StringUtils.isEmpty(t) && StringUtils.isEmpty(t.trim())) {
			errors.rejectValue("perunit", "field.null.notempty", "May by empty but can't contain spaces only");
		}
		t = c.getReport();
		if (!StringUtils.isEmpty(t) && StringUtils.isEmpty(t.trim())) {
			errors.rejectValue("report", "field.null.notempty", "May by empty but can't contain spaces only");
		}
		t = c.getDescription();
		if (!StringUtils.isEmpty(t) && StringUtils.isEmpty(t.trim())) {
			errors.rejectValue("description", "field.null.notempty", "May by empty but can't contain spaces only");
		}
	}

}
