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
//			errors.rejectValue("type", "work.type.hint", "type is empty");
	}

}
